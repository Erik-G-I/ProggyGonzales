package core;

import entity.Entity;
import entity.PlayerState;

public class CollisionCheck {
    GamePanel gp;


    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    public int coins = 0;
    
    private boolean outOfBounds = false;
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
     * @param x1 x-value of first corner
     * @param y1 y-value of first corner
     * @param x2 x-value of second corner
     * @param y2 y-value of second corner
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
    
    public void looseMoney(int x1, int y1, int x2, int y2) {
        gp.getPlayerState();
        int loosingMoney = 15;
        if (gp.getPlayerState() != PlayerState.INVISIBLE && coins >= loosingMoney) {
            if (gp.loader.tiles[cornerOne] == gp.loader.tiles[9]) {
                gp.loader.numOfTiles[x1][y1] = 10;
                coins -= loosingMoney;
        }
    } else if (coins>0 && coins < loosingMoney) {
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[9]) {
            gp.loader.numOfTiles[x1][y1] = 10;
            coins = 0;
    }
        
    }}
    /**
     * Picks up mask and sets player state to invisible
     * @param x1 x-value of first corner
     * @param y1 y-value of first corner
     * @param x2 x-value of second corner
     * @param y2 y-value of second corner
     */
    private void pickUpMask(int x1, int y1, int x2, int y2) {
        if (pickUpGeneric(x1, y1, x2, y2, 12)) {
        	gp.playSoundEffect(4);
            gp.setPLayerState(PlayerState.INVISIBLE);
            gp.truePowerUpTimer();
            gp.player.getPlayerImage();
        }
    }
    private void pickUpScooter(int x1, int y1, int x2, int y2) {
        int scooterCost = 15;
        if (coins>=scooterCost) {
            if (pickUpGeneric(x1, y1, x2, y2, 14)) {
            	gp.playSoundEffect(4);
                gp.setPLayerState(PlayerState.VOI);
                gp.truePowerUpTimer();
                coins -= scooterCost;
                gp.player.getPlayerImage();

            }
        }
    }

    /**
     * 
     * @param x1 x-value of first corner
     * @param y1 y-value of first corner
     * @param x2 x-value of second corner
     * @param y2 y-value of second corner
     * Picks up Shoes and sets player state to Faster
     */
    private void pickUpShoes(int x1, int y1, int x2, int y2) {
        if (pickUpGeneric(x1, y1, x2, y2, 11)) {
        	gp.playSoundEffect(4);
        	gp.setPLayerState(PlayerState.FASTER);
        	gp.truePowerUpTimer();
            System.out.println("Now the player has picked up shoes and should become faster");
            gp.player.getPlayerImage();

        }
    }

    /**
     * Tries to pick up for all possible pickable objects.
     * @param x1 x-value of first corner
     * @param y1 y-value of first corner
     * @param x2 x-value of second corner
     * @param y2 y-value of second corner
     */
    private void pickUp(int x1, int y1, int x2, int y2) {
        pickUpMoney(x1, y1, x2, y2);
        pickUpMask(x1, y1, x2, y2);
        pickUpShoes(x1, y1, x2, y2);
        looseMoney(x1, y1, x2, y2);
        pickUpScooter(x1, y1, x2, y2);
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


                break;
            case "left":
                unitLeftCol = (unitLeftSide - unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitLeftCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUp(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);


                break;
            case "right":
                unitRightCol = (unitRightSide + unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitRightCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUp(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                break;
        }
       }
        catch(ArrayIndexOutOfBoundsException e) {
        	outOfBounds = true;
        	gp.player.setGravity(0); //setting gravity equal to 0 so that Proggy doesn't fall to infinity
        }
    }
}

