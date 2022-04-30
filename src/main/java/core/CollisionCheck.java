package core;

import entity.enemies.EntityEnemy;
import entity.player.PlayerEntity;
import entity.player.PlayerState;
import gameState.GameState;

public class CollisionCheck {

    PlayerEntity player;

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    
    // The two corners of enemies to be checked for collision for each case
    int enemyCor1, enemyCor2;

    public boolean takenMoney = false;
    
    // Used to activate gameOver if proggy falls out of bounds
    private boolean outOfBounds = false;

    // Used to start timer on a picked up power up
    private boolean pickedUpPowerUp = false;

    public CollisionCheck(PlayerEntity player) {
        this.player = player;
    }

    /**
     * Returns outOfBounds boolean check
     * @return field variable: outOfBounds
     */
    public boolean isOutOfBounds() {
    	return outOfBounds;
    }

    /**
     * Creates a help function for picking up money and power ups
     * @param x1 x-value of first corner
     * @param y1 y-value of first corner
     * @param x2 x-value of second corner
     * @param y2 y-value of second corner
     * @param tilenum the type of tile encountered
     * @return true if colliding with a block that can be picked up
     */
    private boolean pickUpGeneric(int x1, int y1, int x2, int y2, int tilenum) {
        if (player.gp.loader.tiles[cornerOne] == player.gp.loader.tiles[tilenum]) {
            // If Proggy collides with object, it turns the tile into tile[0] which is nothing
            player.gp.loader.numOfTiles[x1][y1] = 0;
            return true;
        }
        else if (player.gp.loader.tiles[cornerTwo] == player.gp.loader.tiles[tilenum]) {
            player.gp.loader.numOfTiles[x2][y2] = 0;
            return true;
    }
    return false;
}
    /**
     * Picks up money adding 100 or 200 to "Øl-penger" depending on what bill Proggy has encountered.
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpMoney(int x1, int y1, int x2, int y2) {
        // Pick up 100 kroner
        if (pickUpGeneric(x1, y1, x2, y2, 7)) {
        	player.gp.playSoundEffect(1);
            player.gp.coins += 10;
        }
        // pick up 200-kroner
        if (pickUpGeneric(x1, y1, x2, y2, 8)) {
        	player.gp.playSoundEffect(2);
            player.gp.coins += 20;
        }
    }
  
    /**
     * Enemy-unicef collission
     * @param enemy
     */
  
    public void unicefLooseMoney(EntityEnemy[] enemy) {
        if (this.player.playerState != PlayerState.INVISIBLE) {
            for (int i = 0; i < enemy.length; i++) {
                if(enemy[i] != null) {
                    if(player.worldY == enemy[i].worldY) {
                        if(player.worldX <= enemy[i].worldX + 10 && player.worldX >= enemy[i].worldX - 10) {
                            player.gp.coins --;
                            if(player.gp.coins < 0) {
                                player.gp.coins = 0;
                            }
                            takenMoney = true;
                        }
                    }
                }
            }
        }
    }

    /**Enemy-homeless collission
     * Works much the same as unicef, only using tiles
     */
    private void homelessLooseMoney(int x1, int y1, int x2, int y2) {
        player.gp.getPlayerState1();
        int loosingMoney = 15;
        if (player.playerState != PlayerState.INVISIBLE || player.playerState != PlayerState.INVISIBLE) {
            if (player.gp.coins >= loosingMoney) {
                if (player.gp.loader.tiles[cornerOne] == player.gp.loader.tiles[9]) {
                    player.gp.loader.numOfTiles[x1][y1] = 10;
                    player.gp.coins -= loosingMoney;
                }
            }
            else if (player.gp.coins > 0 && player.gp.coins < loosingMoney) {
                if (player.gp.loader.tiles[cornerOne] == player.gp.loader.tiles[9]) {
                    player.gp.loader.numOfTiles[x1][y1] = 10;
                    player.gp.coins = 0;
                }
            }
        }
    }


    
    /** Method that is activated for each powerup. Activates the power up, plays sound effect, sets player 
    to the state of the belonging power up, starts timer on power up and updates the graphics */
    private void powerUpSequence(int soundEffectNr, PlayerState state) {
        pickedUpPowerUp = true;
        player.gp.playSoundEffect(soundEffectNr);
        player.playerState = state;
        player.gp.truePowerUpTimer(player.getPlayerNum());
        player.getImage();
    }
    /**
     * Picks up mask and sets player state to invisible
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpMask(int x1, int y1, int x2, int y2) {
        if (pickUpGeneric(x1, y1, x2, y2, 12)) {
            powerUpSequence(4, PlayerState.INVISIBLE);
        }
    }
    /**
     * Picks up scooter, which costs 15 coins
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpScooter(int x1, int y1, int x2, int y2) {
        int scooterCost = 5;
        //If the player does not have at least the cost of the scooter, it cannot be picked up
        if (player.gp.coins>=scooterCost) {
            if (pickUpGeneric(x1, y1, x2, y2, 14)) {
                powerUpSequence(4, PlayerState.VOI);
                player.gp.coins -= scooterCost;

            }
        }
    }

    /**
     * Picks up Shoes and sets player state to Faster
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpShoes(int x1, int y1, int x2, int y2) {
        if (pickUpGeneric(x1, y1, x2, y2, 11)) {
            powerUpSequence(4, PlayerState.FASTER);

        }
    }
    
    /**
     * Player can pick up the beer and win the game only when the player has enough coins
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpBeer(int x1, int y1, int x2, int y2) {
        if(player.gp.coins >= 100) { //check for winning
            if (pickUpGeneric(x1, y1, x2, y2, 16)) {
                player.gp.playSoundEffect(4);
                player.gp.gameState = GameState.WIN_SCREEN; //switches to winning screen
            }
        }
    }

    /**
     * Tries to pick up for all possible pickable objects.
     */
    private void pickUp(int x1, int y1, int x2, int y2) {
        pickUpMoney(x1, y1, x2, y2);
        pickUpMask(x1, y1, x2, y2);
        pickUpShoes(x1, y1, x2, y2);
        unicefLooseMoney(player.gp.unicef);
        homelessLooseMoney(x1, y1, x2, y2);
        pickUpScooter(x1, y1, x2, y2);
        pickUpBeer(x1, y1, x2, y2);
    }

    /**
     * Helper method to start timer on how long the power up should last - will be used by GamePanel and from there used in Time
     */
    public boolean getPickedUpPowerUp() {
    	return this.pickedUpPowerUp;
    }

    /** 
     * This is used when Proggy picks up a power up while already having a power up to restart the countdown to when the power up ends
     * - will be used by GamePanel and from there used in Time
     */
    public void setPickedUpPowerUp(boolean pickedUpPowerUp) {
        this.pickedUpPowerUp = pickedUpPowerUp;
    }
    
    /**
     * Checks the collision with water tile number 5
     * If there's a collision outOfBounds variable will be true
     * So the player gets game over if the player falls in water
     */
    public void fellInWater() {
        if (player.gp.loader.tiles[cornerOne] == player.gp.loader.tiles[5]) {
            this.outOfBounds = true;
        }
        else if (player.gp.loader.tiles[cornerTwo] == player.gp.loader.tiles[5]) {
            this.outOfBounds = true;
        }
        else {
            this.outOfBounds = false;
        }
    }

    /**
     * This follows the same system as getPickedUpPowerUp and setPickedUpPowerUp
     * This is used to reduce coins by 1. It is used in GamePanel and Time uses it on its gamePanel
     */
    public void reduceCoins() {
        this.player.gp.coins --;
    }

    /**
     * This follows the same system as getPickedUpPowerUp and setPickedUpPowerUp
     * This is used to find out how many coins Proggy has
     */
    public int getCoins() {
        return this.player.gp.coins;
    }
    public void setCoins(int i) {
        this.player.gp.coins = i;
    }

    /**
     * Creates sides and corners of player. This makes it possible to make a collision with tiles
     * Different cases have different corners to check for collision.
     */
    public void checkCollisionOnTile() {
        // Creating the sides of the solid area of Proggy. If these sides hit a solid block, it will create a collision.
        int unitLeftSide = player.solid.x + player.worldX;
        int unitRightSide =  player.solid.width + player.worldX;
        int unitTopSide = player.solid.y + player.worldY;
        int unitBottomSide = player.worldY - player.solid.y + player.solid.height;

        // This must be adjusted for tilesize to find the columns and rows they are at
        int unitLeftCol = unitLeftSide / this.player.gp.tileSize;
        int unitRightCol = unitRightSide / this.player.gp.tileSize;
        int unitTopRow = unitTopSide / this.player.gp.tileSize;
        int unitBottomRow = unitBottomSide / this.player.gp.tileSize;

        try {
            switch(player.direction) {
                case "up":
                    //If Proggy moves in an upwards direction, the two corners that needs to be checked is top right and left corners
                    unitTopRow = (unitTopSide - player.speed) / this.player.gp.tileSize; //predictiong which tile Proggy tries to go into
                    cornerOne = this.player.gp.loader.numOfTiles[unitLeftCol][unitTopRow]; // Top left corner
                    cornerTwo = this.player.gp.loader.numOfTiles[unitRightCol][unitTopRow]; // Top right corner
                    if (this.player.gp.loader.tiles[cornerOne].collission == true || this.player.gp.loader.tiles[cornerTwo].collission == true) {
                        // if one of these corners collide, collision is true
                        player.colliding = true;
                    }
                    this.pickUp(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);


                    break;


                case "down":
                    //If Proggy moves in an downwards direction, the two corners that needs to be checked is bottom right and left corners
                    unitBottomRow = (unitBottomSide + player.speed) / this.player.gp.tileSize; //predictiong which tile Proggy tries to go into
                    cornerOne = this.player.gp.loader.numOfTiles[unitLeftCol][unitBottomRow]; // Bottom left corner
                    cornerTwo = this.player.gp.loader.numOfTiles[unitRightCol][unitBottomRow]; // Bottom right corner
                    if (this.player.gp.loader.tiles[cornerOne].collission == true || this.player.gp.loader.tiles[cornerTwo].collission == true) {
                        player.colliding = true;
                        // We also introduce a boolean to check if Proggy is colliding with the ground.
                        // This is used to check if porggy is allowed to jump again.
                        player.onGround = true;
                    }

                    this.pickUp(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                    this.fellInWater();


                    break;
                case "left":
                    unitLeftCol = (unitLeftSide - player.speed) / this.player.gp.tileSize;
                    cornerOne = this.player.gp.loader.numOfTiles[unitLeftCol][unitTopRow];
                    cornerTwo = this.player.gp.loader.numOfTiles[unitLeftCol][unitBottomRow];
                    if (this.player.gp.loader.tiles[cornerOne].collission == true || this.player.gp.loader.tiles[cornerTwo].collission == true) {
                        player.colliding = true;
                    }
                    // Will pick up whatever is in the new tile
                    this.pickUp(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);


                    break;
                case "right":
                    unitRightCol = (unitRightSide + player.speed) / this.player.gp.tileSize;
                    cornerOne = this.player.gp.loader.numOfTiles[unitRightCol][unitTopRow];
                    cornerTwo = this.player.gp.loader.numOfTiles[unitRightCol][unitBottomRow];
                    if (this.player.gp.loader.tiles[cornerOne].collission == true || this.player.gp.loader.tiles[cornerTwo].collission == true) {
                        player.colliding = true;
                    }
                    // Will pick up whatever is in the new tile
                    this.pickUp(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                    break;
            }
        }

       // If proggy falls out of bounds this is triggered
        catch(ArrayIndexOutOfBoundsException e) {
            outOfBounds = true;
            player.setGravity(0); //setting gravity equal to 0 so that Proggy doesn't fall to infinity
        }
    }
    
    /**
     * Works much the same as checkCollisionOnTile, but makes it so enemies can't pick up objects 
     * @param entityEnemy
     */
    public void checkEnemyOnTile(EntityEnemy entityEnemy) {
        // Creating the sides of the solid area of Enemy. If these sides hit a solid block, it will create a collision.
        int enemyleftworldx = entityEnemy.worldX + entityEnemy.solid.x;
        int enemyrightworldx =  entityEnemy.worldX + entityEnemy.solid.x + entityEnemy.solid.width;
        int enemytopworldy = entityEnemy.worldY + entityEnemy.solid.y;
        int enemybottomworldy = entityEnemy.worldY + entityEnemy.solid.y + entityEnemy.solid.height;

        // This must be adjusted for tilesize to find the columns and rows they are at
        int enemyLeftCol = enemyleftworldx / player.gp.tileSize;
        int enemyRightCol = enemyrightworldx / player.gp.tileSize;
        int enemyTopRow = enemytopworldy / player.gp.tileSize;
        int enemyBottomRow = enemybottomworldy / player.gp.tileSize;

                
                
                switch(entityEnemy.direction) {
                    case "down":
                        //If Proggy moves in an downwards direction, the two corners that needs to be checked is bottom right and left corners
                        enemyBottomRow = (enemybottomworldy + entityEnemy.speed) / player.gp.tileSize; //predictiong which tile Proggy tries to go into
                        enemyCor1 = player.gp.loader.numOfTiles[enemyLeftCol][enemyBottomRow]; // Bottom left corner
                        enemyCor2 = player.gp.loader.numOfTiles[enemyRightCol][enemyBottomRow]; // Bottom right corner
                        if (player.gp.loader.tiles[enemyCor1].collission == true || player.gp.loader.tiles[enemyCor2].collission == true) {
                            entityEnemy.colliding = true;
                            entityEnemy.onGround = true;
                        }
                        break;

                    case"enemyLeft":
                        enemyLeftCol = (enemyleftworldx - entityEnemy.speed) / player.gp.tileSize; //predictiong which tile Enemy tries to go into
                        enemyCor1 = player.gp.loader.numOfTiles[enemyLeftCol][enemyTopRow]; // Top left corner
                        enemyCor2 = player.gp.loader.numOfTiles[enemyLeftCol][enemyBottomRow]; // Top right corner
                        if(player.gp.loader.tiles[enemyCor1].collission == true) {
                            entityEnemy.colliding = true;

                        }
                        break;

                    case"enemyRight":
                        enemyRightCol = (enemyrightworldx - entityEnemy.speed) / player.gp.tileSize; //predictiong which tile Enemy tries to go into
                        enemyCor1 = player.gp.loader.numOfTiles[enemyRightCol][enemyTopRow]; // Top left corner
                        enemyCor2 = player.gp.loader.numOfTiles[enemyRightCol][enemyBottomRow]; // Top right corner
                        if(player.gp.loader.tiles[enemyCor1].collission == true) {
                            entityEnemy.colliding = true;

                        }
                        break;
 
               }
    }

}

