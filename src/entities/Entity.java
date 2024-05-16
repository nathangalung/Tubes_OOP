package src.entities;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

import src.entities.handlers.*;
import src.mains.KeyHandler;
import src.entities.plants.Plant;
import src.entities.zombies.Zombie;

public abstract class Entity {
    private int x;
    private int y;
    private int width;
    private int height;
    private float speed;
    private int direction;

    // CONSTRUCTOR
    public Entity(int x, int y, int width, int height, int direction) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction = direction;
    }

    // GETTERS
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

    public int getDirection() {
        return direction;
    }

    // SETTERS
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void checkCollision(CollisionHandler collisionHandler, int newX, int newY) {
    }

    public boolean isMoving(int newX, int newY) {
        if (this instanceof Plant || this instanceof Zombie) {
            if (!isCollision(newX, newY)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
    }

    // public void checkCollision(CollisionHandler collisionHandler, int newX, int newY) {
    //     if (collisionHandler.isCollision(newX, newY)) {
    //         return ;
    //     }

    //     x = newX;
    //     y = newY;
    // }

    // public boolean isAttacking() {
    //     if (range > 0) {
    //         if ()
    //     }
    //     else {
    //         return false;
    //     }
    // }

    // public void attack(CollisionHandler collisionHandler) {
    //     // Move the zombie
    //     int newX = x;
    //     int newY = y;
    //     float speed = (float) (Consts.SCALED_TILE / 4.7);

    //     if (isAttacking()) {
    //         newX += speed;
    //     }
    //     checkCollision(collisionHandler, newX, newY);
    // }

    public void movePZ(CollisionHandler collisionHandler, InteractionHandler interactionHandler) {
    }

    public void moveS(CollisionHandler collisionHandler) {
    }
}
