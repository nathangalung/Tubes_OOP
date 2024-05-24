package src.entities;

import java.awt.Graphics2D;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Entity {
    private int x,y;
    private int width;
    private int height;
    private int speed;
    private int direction;

    private Rectangle bound;

    public Entity(int x, int y, int width, int height, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.direction = direction;
        bound = new Rectangle(x, y, width , height);
    }

    public void initBound() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public Rectangle getBound() {
        return bound;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
}
