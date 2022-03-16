package core;

import entity.Entity;

public class CollisionCheck {
    GamePanel gp;

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
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

        // The two corners of proggy to be checked for collision for each case
        int cornerOne, cornerTwo;

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
                    // This is used to check if porggy is allowed to jump again.
                    unit.onGround = true;
                }
                
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
                // int neutralizedSpeed4 = unitRightSide + unit.speed;
                // directionColliding(unit, unitBottomRow, neutralizedSpeed4, unitRightCol, unitTopRow, unitRightCol, unitBottomRow);
                break;
        }

       
    }
    // The following is a method to try to avoid using code repedeatly

    // boolean directionColliding(Entity unit, int facingColRow, int facingSideSpeed, int corner1X, int corner1Y, int corner2X, int corner2Y) {
    //     facingColRow = facingSideSpeed / gp.tileSize; //predictiong which tile Proggy tries to go into
    //     int cornerOne = gp.loader.numOfTiles[corner1X][corner1Y]; // Bottom left corner
    //     int cornerTwo = gp.loader.numOfTiles[corner2X][corner2Y]; // Bottom right corner
    //     if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
    //         unit.colliding = true;
    //         return true;
    //     } else {
    //         return false;
    //     }}

}