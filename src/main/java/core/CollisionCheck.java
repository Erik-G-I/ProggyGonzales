package core;

import enemies.entityEnemy;
import entity.Entity;
import entity.Player;
import entity.PlayerState;
import gameState.GameState;

public class CollisionCheck {
    GamePanel gp;

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    
    // The two corners of enemies to be checked for collision for each case
    int enemyCor1, enemyCor2;

    public int coins = 0;

    
    // Used to activate gameOver if proggy falls out of bounds
    private boolean outOfBounds = false;

    // Used to start timer on a picked up power up
    private boolean pickedUpPowerUp = false;
 

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
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
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[tilenum]) {
            // If Proggy collides with object, it turns the tile into tile[0] which is nothing
            gp.loader.numOfTiles[x1][y1] = 0;
            return true;
        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[tilenum]) {
            gp.loader.numOfTiles[x2][y2] = 0;
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
        	gp.playSoundEffect(1);
            coins += 10;
        }
        // pick up 200-kroner
        if (pickUpGeneric(x1, y1, x2, y2, 8)) {
        	gp.playSoundEffect(2);
            coins += 20;
        }
    }
    
  //Enemy collission
    public boolean looseMoney(Player player, entityEnemy[] enemy) {
			if (gp.getPlayerState() != PlayerState.INVISIBLE) {
    			for (int i = 0; i < enemy.length; i++) {
    				if(enemy[i] != null) {
    	    			if(gp.player.worldY == enemy[i].worldY) {
    	    				if(gp.player.worldX <= enemy[i].worldX + 20 && gp.player.worldX >= enemy[i].worldX - 20) {
        	    				coins --;
        	    				if(coins < 0) {
        	    					   coins = 0;
        	    					}
        	    				return true;
    	    				}
    	   				}
    				}
    			}
			}
			
			return false;
    }


    
    /* Method that is activated for each powerup. Activates the power up, plays sound effect, sets player 
    to the state of the belonging power up, starts timer on power up and updates the graphics */
    private void powerUpSequence(int soundEffectNr, PlayerState state) {
        pickedUpPowerUp = true;
        gp.playSoundEffect(soundEffectNr);
        gp.setPlayerState(state);
        gp.truePowerUpTimer();
        gp.player.getPlayerImage();
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
        if (coins>=scooterCost) {
            if (pickUpGeneric(x1, y1, x2, y2, 14)) {
                powerUpSequence(4, PlayerState.VOI);
                coins -= scooterCost;

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
            System.out.println("Now the player has picked up shoes and should become faster");

        }
    }
    
    /**
     * Player can pick up the beer and win the game only when the player has enough coins
     * parameters x1, y1, x2, y2 is the same as pickUpGeneric
     */
    private void pickUpBeer(int x1, int y1, int x2, int y2) {
    	if(coins >= 100) { //check for winning
    	if (pickUpGeneric(x1, y1, x2, y2, 16)) {
    		gp.playSoundEffect(4);
            gp.gameState = GameState.WIN_SCREEN; //switches to winning screen
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
        looseMoney(gp.player, gp.hobo);
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
     * Checks the collision with water tile number 17
     * If there's a collision outOfBounds variable will be true
     * So the player gets game over if the player falls in water
     */
    public void fellInWater() {
    	if (gp.loader.tiles[cornerOne] == gp.loader.tiles[17]) {
    		this.outOfBounds = true;
    	}
    	else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[17]) {
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
        this.coins --;
    }

    /**
     * This follows the same system as getPickedUpPowerUp and setPickedUpPowerUp
     * This is used to find out how many coins Proggy has
     */
    public int getCoins() {
        return this.coins;
    }
    public void setCoins(int i) {
        this.coins = i;
    }


    public void checkCollisionOnTile(Entity unit) {
        // Creating the sides of the solid area of Proggy. If these sides hit a solid block, it will create a collision.
        int unitLeftSide = unit.playerSolid.x + unit.worldX;
        int unitRightSide =  unit.playerSolid.width + unit.worldX;
        int unitTopSide = unit.playerSolid.y + unit.worldY;
        int unitBottomSide = unit.worldY - unit.playerSolid.y + unit.playerSolid.height;

        // This must be adjusted for tilesize to find the columns and rows they are at
        int unitLeftCol = unitLeftSide / gp.tileSize;
        int unitRightCol = unitRightSide / gp.tileSize;
        int unitTopRow = unitTopSide / gp.tileSize;
        int unitBottomRow = unitBottomSide / gp.tileSize;

        try {
        switch(unit.direction) {
            case "up":
                //If Proggy moves in an upwards direction, the two corners that needs to be checked is top right and left corners
                unitTopRow = (unitTopSide - unit.speed) / gp.tileSize; //predictiong which tile Proggy tries to go into
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow]; // Top left corner
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitTopRow]; // Top right corner
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    // if one of these corners collide, collision is true
                    unit.colliding = true;
                }
                this.pickUp(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);

            
                break;


            case "down":
                //If Proggy moves in an downwards direction, the two corners that needs to be checked is bottom right and left corners
                unitBottomRow = (unitBottomSide + unit.speed) / gp.tileSize; //predictiong which tile Proggy tries to go into
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitBottomRow]; // Bottom left corner
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow]; // Bottom right corner
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                    // We also introduce a boolean to check if Proggy is colliding with the ground.
                    // This is used to check if porggy is allowed to jump again.
                    unit.onGround = true;
                }
                
                this.pickUp(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                this.fellInWater();


                break;
            case "left":
                unitLeftCol = (unitLeftSide - unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitLeftCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                // Will pick up whatever is in the new tile                
                this.pickUp(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);


                break;
            case "right":
                unitRightCol = (unitRightSide + unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitRightCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                // Will pick up whatever is in the new tile 
                this.pickUp(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                break;
        }
       }

       // If proggy falls out of bounds this is triggered
        catch(ArrayIndexOutOfBoundsException e) {
        	outOfBounds = true;
        	gp.player.setGravity(0); //setting gravity equal to 0 so that Proggy doesn't fall to infinity
        }
    }
    
    public void checkEnemyOnTile(entityEnemy entityEnemy) {
        // Creating the sides of the solid area of Enemy. If these sides hit a solid block, it will create a collision.
        int enemyleftworldx = entityEnemy.worldX + entityEnemy.enemySolid.x;
        int enemyrightworldx =  entityEnemy.worldX + entityEnemy.enemySolid.x + entityEnemy.enemySolid.width;
        int enemytopworldy = entityEnemy.worldY + entityEnemy.enemySolid.y;
        int enemybottomworldy = entityEnemy.worldY + entityEnemy.enemySolid.y + entityEnemy.enemySolid.height;

        // This must be adjusted for tilesize to find the columns and rows they are at
        int enemyLeftCol = enemyleftworldx / gp.tileSize;
        int enemyRightCol = enemyrightworldx / gp.tileSize;
        int enemyTopRow = enemytopworldy / gp.tileSize;
        int enemyBottomRow = enemybottomworldy / gp.tileSize;

                
                
                switch(entityEnemy.direction) {
                
                
                case "down":
                    //If Proggy moves in an downwards direction, the two corners that needs to be checked is bottom right and left corners
                	enemyBottomRow = (enemybottomworldy + entityEnemy.speed) / gp.tileSize; //predictiong which tile Proggy tries to go into
                	enemyCor1 = gp.loader.numOfTiles[enemyLeftCol][enemyBottomRow]; // Bottom left corner
                	enemyCor2 = gp.loader.numOfTiles[enemyRightCol][enemyBottomRow]; // Bottom right corner
                    if (gp.loader.tiles[enemyCor1].collission == true || gp.loader.tiles[enemyCor2].collission == true) {
                    	entityEnemy.colliding = true;
                    	entityEnemy.onGround = true;
                    }
                    break;
                    
                case"enemyLeft":
                	enemyLeftCol = (enemyleftworldx - entityEnemy.speed) / gp.tileSize; //predictiong which tile Enemy tries to go into
                    enemyCor1 = gp.loader.numOfTiles[enemyLeftCol][enemyTopRow]; // Top left corner
                    enemyCor2 = gp.loader.numOfTiles[enemyLeftCol][enemyBottomRow]; // Top right corner
                    if(gp.loader.tiles[enemyCor1].collission == true) {
                     	entityEnemy.colliding = true;
                     	
                    }
                    break;
                    
                case"enemyRight":
                	enemyRightCol = (enemyrightworldx - entityEnemy.speed) / gp.tileSize; //predictiong which tile Enemy tries to go into
                    enemyCor1 = gp.loader.numOfTiles[enemyRightCol][enemyTopRow]; // Top left corner
                    enemyCor2 = gp.loader.numOfTiles[enemyRightCol][enemyBottomRow]; // Top right corner
                    if(gp.loader.tiles[enemyCor1].collission == true) {
                     	entityEnemy.colliding = true;
                     	
                    }
                    break;
 
               }
    }

}

