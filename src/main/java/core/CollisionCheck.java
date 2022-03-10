package core;

import entity.Entity;

public class CollisionCheck {
    GamePanel gp;

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.playerSolid.x;
        int entityRightWorldX = entity.worldX - entity.playerSolid.x + entity.playerSolid.width;
        int entityTopWorldY = entity.worldY + entity.playerSolid.y;
        int entityBottomWorldY = entity.worldY - entity.playerSolid.y + entity.playerSolid.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.loader.numOfTiles[entityLeftCol][entityTopRow];
                tileNum2 = gp.loader.numOfTiles[entityRightCol][entityTopRow];
                if (gp.loader.tiles[tileNum1].collission == true || gp.loader.tiles[tileNum2].collission == true) {
                    entity.colliding = true;
//                    entity.hitHead = true;
                    
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.loader.numOfTiles[entityLeftCol][entityBottomRow];
                tileNum2 = gp.loader.numOfTiles[entityRightCol][entityBottomRow];
                if (gp.loader.tiles[tileNum1].collission == true || gp.loader.tiles[tileNum2].collission == true) {
                    entity.colliding = true;
                    entity.onGround = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.loader.numOfTiles[entityLeftCol][entityTopRow];
                tileNum2 = gp.loader.numOfTiles[entityLeftCol][entityBottomRow];
                if (gp.loader.tiles[tileNum1].collission == true || gp.loader.tiles[tileNum2].collission == true) {
                    entity.colliding = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.loader.numOfTiles[entityRightCol][entityTopRow];
                tileNum2 = gp.loader.numOfTiles[entityRightCol][entityBottomRow];
                if (gp.loader.tiles[tileNum1].collission == true || gp.loader.tiles[tileNum2].collission == true) {
                    entity.colliding = true;
                }
                break;
        }

        
    }
    
}
