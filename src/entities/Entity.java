// package src.entities;

// import java.awt.image.BufferedImage;
// import java.util.List;

// import plants.Sun;

// import java.util.ArrayList;

// import src.entities.handlers.*;
// import src.mains.KeyHandler;
// import src.entities.plants.Plant;
// import src.entities.zombies.Zombie;

// public abstract class Entity {
//     private int x;
//     private int y;
//     private int width;
//     private int height;
//     private int speed;
//     private int direction;
//     private int damage;

//     // CONSTRUCTOR
//     public Entity(int x, int y, int width, int height, int speed, int direction, int damage) {
//         this.x = x;
//         this.y = y;
//         this.width = width;
//         this.height = height;
//         this.speed = speed;
//         this.direction = direction;
//         this.damage = damage;
//     }

//     // GETTERS
//     public int getX() {
//         return x;
//     }

//     public int getY() {
//         return y;
//     }

//     public int getWidth() {
//         return width;
//     }

//     public int getHeight() {
//         return height;
//     }

//     public int getSpeed() {
//         return speed;
//     }

//     public int getDirection() {
//         return direction;
//     }

//     public int getdamage() {
//         return damage;
//     }

//     // SETTERS
//     public void setX(int x) {
//         this.x = x;
//     }

//     public void setY(int y) {
//         this.y = y;
//     }

//     public boolean isMoving(int newX, int newY) {
//         if (this instanceof Zombie || this instanceof Bullet) {
//             if (!CollisionHandler.isCollision(newX, newY)) {
//                 return true;
//             }
//             return false;
//         }
//         if (this instanceof Sun) {
//             return true;
//         }

//         return false;
//     }

//     public boolean isAttacking(int newX, int newY) {
//         if (this instanceof Plant) {
//             if (Plant.getRange() > 0) {
//                 if (CollisionHandler.isCollision(newX, newY)) {
//                     return true;
//                 }
//             }
//             else if (Plant.getRange() == -1 ) {
//                 return true;
//             }
//         }
//         if (this instanceof Zombie) {
//             if (!CollisionHandler.isCollision(newX, newY)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     public void checkCollision(CollisionHandler collisionHandler, int newX, int newY) {
//     }

//     // public void checkCollision(CollisionHandler collisionHandler, int newX, int newY) {
//     //     if (collisionHandler.isCollision(newX, newY)) {
//     //         return ;
//     //     }

//     //     x = newX;
//     //     y = newY;
//     // }

//     // public boolean isdamageing() {
//     //     if (range > 0) {
//     //         if ()
//     //     }
//     //     else {
//     //         return false;
//     //     }
//     // }

//     // public void damage(CollisionHandler collisionHandler) {
//     //     // Move the zombie
//     //     int newX = x;
//     //     int newY = y;
//     //     float speed = (float) (Consts.SCALED_TILE / 4.7);

//     //     if (isdamageing()) {
//     //         newX += speed;
//     //     }
//     //     checkCollision(collisionHandler, newX, newY);
//     // }

//     public void move(CollisionHandler collisionHandler, InteractionHandler interactionHandler) {
//         int newX = x;
//         int newY = y;
//         int initialSpeed = speed;

//         if (isMoving(newX, newY)) {
//             if (this instanceof Bullet) {
//                 newX += speed;
//                 direction = 1;
//                 interactionHandler.moveRight(newX, newY);
//             }
//             if (this instanceof Sun) {
//                 newY += speed;
//                 direction = 2;
//                 interactionHandler.moveDown(newX, newY);
//             }
//             if (this instanceof Zombie) {
//                 newY += speed;
//                 direction = 3;
//                 interactionHandler.moveLeft(newX, newY);
//             }
//             checkCollision(collisionHandler, newX, newY);
//         }
//         speed = initialSpeed;
//     }

//     public void attack(CollisionHandler collisionHandler, InteractionHandler interactionHandler) {
//         int initialDamage = damage;

//         if (isAttacking())
//     }
// }
