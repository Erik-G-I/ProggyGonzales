package core;

import entity.Entity;

public class CollisionCheck {
    GamePanel gp;

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    public int coins = 0;

    public void pickUpMoney(int x1, int y1, int x2, int y2) {
        //om proggy collider med penger blir den gjort om til tiles[0] aka ingenting
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[7]) {
            gp.loader.numOfTiles[x1][y1] = 0;
            coins += 10;
        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[7]) {
            gp.loader.numOfTiles[x2][y2] = 0;
            coins += 10;
        }
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[8]) {
            gp.loader.numOfTiles[x1][y1] = 0;
            coins += 20;
        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[8]) {
            gp.loader.numOfTiles[x2][y2] = 0;
            coins += 20;
        }

    }

    
    public void looseMoney(int x1, int y1, int x2, int y2) {
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[9]) {
            gp.loader.numOfTiles[x1][y1] = 10;
            coins -= 15;

        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[9]) {
            gp.loader.numOfTiles[x2][y2] = 10;
            coins -= 15;
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
                this.pickUpMoney(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);
                this.looseMoney(unitLeftCol, unitTopRow, unitRightCol, unitTopRow);
                //entity.hitHead = true;
                // int neutralizedSpeed = unitTopSide - unit.speed;
                // directionColliding(unit, unitTopRow, neutralizedSpeed, unitLeftCol, unitTopRow, unitRightCol, unitTopRow);
                break;


            case "down":
                //If Proggy moves in an downwards direction, the two corners that needs to be checked is bottom right and left corners
                unitBottomRow = (unitBottomSide + unit.speed) / gp.tileSize; //predictiong which tile Proggy tries to go into
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitBottomRow]; // Bottom left corner
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow]; // Bottom right corner
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                    // We also introduce a boolean to check if Proggy is colliding with the ground.
                    // This is used to check if Proggy is allowed to jump again.
                    unit.onGround = true;
                }

                this.pickUpMoney(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                this.looseMoney(unitLeftCol, unitBottomRow, unitRightCol, unitBottomRow);
                // int neutralizedSpeed2 = unitBottomSide + unit.speed;
                // directionColliding(unit, unitBottomRow, neutralizedSpeed2, unitLeftCol, unitBottomRow, unitRightCol, unitBottomRow);
                // if (directionColliding(unit, unitBottomRow, neutralizedSpeed2, unitLeftCol, unitBottomRow, unitRightCol, unitBottomRow)){
                //     unit.onGround = true;
                // }
                break;
            case "left":
                unitLeftCol = (unitLeftSide - unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitLeftCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUpMoney(unitLeftCol,unitTopRow, unitLeftCol, unitBottomRow);
                this.looseMoney(unitLeftCol, unitTopRow, unitLeftCol, unitBottomRow);
                // int neutralizedSpeed3 = unitLeftSide - unit.speed;
                // directionColliding(unit, unitBottomRow, neutralizedSpeed3, unitLeftCol, unitTopRow, unitLeftCol, unitBottomRow);

                break;
            case "right":
                unitRightCol = (unitRightSide + unit.speed) / gp.tileSize;
                cornerOne = gp.loader.numOfTiles[unitRightCol][unitTopRow];
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitBottomRow];
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    unit.colliding = true;
                }
                this.pickUpMoney(unitRightCol,unitTopRow, unitRightCol, unitBottomRow);
                this.looseMoney(unitRightCol, unitTopRow, unitRightCol, unitBottomRow);
                // int neutralizedSpeed4 = unitRightSide + unit.speed;
                // directionColliding(unit, unitBottomRow, neutralizedSpeed4, unitRightCol, unitTopRow, unitRightCol, unitBottomRow);
                break;
        }


    }



}
