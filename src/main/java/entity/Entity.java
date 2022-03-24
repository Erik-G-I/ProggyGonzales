package entity;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;


public class Entity {

    public int worldX, worldY;
    public int playerX, playerY;
    public int speed;
    
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, bakgrunn;
    public String direction;
    public String previousDirection;
    
    public int jumpStrength;
    public Rectangle playerSolid;
    public boolean colliding = false;

    public boolean onGround = true;

    // sprites are used to create animation on the player and enemies
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    
}

