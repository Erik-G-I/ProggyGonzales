package core;

import entity.Entity;
import entity.Player;
import entity.PlayerState;

public class CollisionCheck {
    GamePanel gp;


    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    public int coins = 0;


    public boolean pickUp(int x1, int y1, int x2, int y2, int tilenum) {
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[tilenum]) {
            gp.loader.numOfTiles[x1][y1] = 0;
            return true;
        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[tilenum]) {
            gp.loader.numOfTiles[x2][y2] = 0;
            return true;

    }
    return false;
}



    public void pickUpFromGround(int x1, int y1, int x2, int y2) {
        //om proggy collider med penger blir den gjort om til tiles[0] aka ingenting
        // Pick up 100 kroner
        if (pickUp(x1, y1, x2, y2, 7)) {
            coins += 100;
        }
        // pick up 200-kroner
        if (pickUp(x1, y1, x2, y2, 8)) {
            coins += 200;
        }

        //pick up mask
        if (pickUp(x1, y1, x2, y2, 12)) {
            gp.playerState = PlayerState.INVISIBLE;
        }
        // Pick up shoes
        if (pickUp(x1, y1, x2, y2, 11)) {
            gp.playerState = PlayerState.FASTER;
            System.out.println("Now the player has picked up shoes and should become faster");
        }

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
                this.pickUpFromGround(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);
                // this.pickUpMask(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);
                // this.pickUpShoes(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);

            
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

                this.pickUpFromGround(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                // this.pickUpMask(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                // this.pickUpShoes(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);

                break;
            case "left":
                unitLeftCol = (unitLeftSide - unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitLeftCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUpFromGround(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);
                // this.pickUpMask(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);
                // this.pickUpShoes(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);

                break;
            case "right":
                unitRightCol = (unitRightSide + unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitRightCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUpFromGround(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                // this.pickUpMask(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                // this.pickUpShoes(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                break;
        }
    }
}

