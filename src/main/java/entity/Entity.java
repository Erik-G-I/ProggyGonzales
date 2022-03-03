package entity;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;


public class Entity {

    
    public int worldX, worldY;
    public int playerX, playerY;
    public int speed;
    
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, bakgrunn;
    public String direction;
    
    public Rectangle playerSolid;
    public boolean colliding = false;


    //brukes til å skape animasjon på spiller og fiender
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    
}

