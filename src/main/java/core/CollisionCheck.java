package core;

import java.awt.Font;

import entity.Entity;
import entity.Player;
import entity.Score;
import tile.Tile;
import timer.Time;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.Timer;

public class CollisionCheck extends Entity {
    GamePanel gp;
    ArrayList<Tile> fjernFørste = new ArrayList<Tile>();
    ArrayList<Tile> GjørOm = new ArrayList<Tile>();

    int index = 0;
    public int coins;

    // The two corners of proggy to be checked for collision for each case
    int cornerOne, cornerTwo;
    
    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    	/**for(Tile t : gp.loader.tiles) {
    		if(t == gp.loader.tiles[5]) {
    			fjernFørste.add(t);
    		}
    	}*/
    }

    public void pickUpMoney(int x1, int y1, int x2, int y2) {
        //om proggy collider med penger blir den gjort om til tiles[0] aka ingenting
        if (gp.loader.tiles[cornerOne] == gp.loader.tiles[5]) {
            if (gp.loader.tiles[5].collission == true) {
                gp.loader.numOfTiles[x1][y1] = 0;
                coins += 50;
            }
        }
        else if (gp.loader.tiles[cornerTwo] == gp.loader.tiles[5]) {
            if (gp.loader.tiles[5].collission == true) {
                gp.loader.numOfTiles[x2][y2] = 0;
                coins += 50;
            }
        }
    }

    
    public void checkCollisionOnTile(Entity unit) {
    	// Creating the sides of the solid area of Proggy. If these sides hit a solid block, it will create a collision.
        int unitLeftSide = unit.playerSolid.x + unit.worldX; //
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
                unitTopRow = (unitTopSide - unit.speed) / gp.tileSize; //predicting which tile Proggy tries to go into
                cornerOne = gp.loader.numOfTiles[unitLeftCol][unitTopRow]; // Top left corner
                cornerTwo = gp.loader.numOfTiles[unitRightCol][unitTopRow]; // Top right corner
                
                
                if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
                    // if one of these corners collide, collision is true
                    unit.colliding = true; 
                }

                this.pickUpMoney(unitLeftCol,unitTopRow, unitRightCol, unitTopRow);

                	//	GjørOm = fjernFørste[index];
                    	//fjernFørste.remove(index);
            //        	gp.loader.tiles[5].collission = false;
                
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
                    // This is used to check if proggy is allowed to jump again.
                    unit.onGround = true;

                }
                this.pickUpMoney(unitLeftCol,unitBottomRow, unitRightCol, unitBottomRow);
                
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

                // int neutralizedSpeed4 = unitRightSide + unit.speed;
                // directionColliding(unit, unitBottomRow, neutralizedSpeed4, unitRightCol, unitTopRow, unitRightCol, unitBottomRow);
                break;
        }
    }
    // The following is a method to try to avoid using code repedeatly

    /**boolean directionColliding(Entity unit, int facingColRow, int facingSideSpeed, int corner1X, int corner1Y, int corner2X, int corner2Y) {
    //     facingColRow = facingSideSpeed / gp.tileSize; //predictiong which tile Proggy tries to go into
    //     int cornerOne = gp.loader.numOfTiles[corner1X][corner1Y]; // Bottom left corner
    //     int cornerTwo = gp.loader.numOfTiles[corner2X][corner2Y]; // Bottom right corner
    //     if (gp.loader.tiles[cornerOne].collission == true || gp.loader.tiles[cornerTwo].collission == true) {
    //         unit.colliding = true;
    //         return true;
    //     } else {
    //         return false;
         }}*/

}
