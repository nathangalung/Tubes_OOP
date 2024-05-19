package src.entities.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;

import src.entities.Entity;
import src.entities.interactables.Interactables;
import src.entities.plants.Plant;
import src.maps.Map;

public class InteractionHandler {
    // Attributes
    private Entity entity;
    private Rectangle rectangle;
    private Map currentTile;
    private int x;
    private int y;
    private int width;
    private int height;

    // CONSTRUCTOR
    public InteractionHandler(Entity entity, Map currentTile) {
        this.entity = entity;
        this.currentTile = currentTile;
        this.x = entity.getX();
        this.y = entity.getY() + entity.getHeight();
        this.width = entity.getWidth();
        this.height = entity.getHeight() / 3;
        rectangle = new Rectangle(x, y, width, height);
    }

    // GETTER
    public Entity getEntity() {
        return entity;
    }

    public Rectangle getRectangle() {
        return rectangle;
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

    public boolean isObjectInRange() {
        ArrayList<Plant> plantsList = currentTile.getPlantsList(); 

        for (Plant object : plantsList) {
            if (getRectangle().intersects(object.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public boolean isPlantInRange() {
        ArrayList<Plant> plantsList = currentTile.getPlantsList(); 

        for (Plant plant : plantsList) {
            if (getRectangle().intersects(plant.getBounds())) {
                return true;
            }
        }
        return false;
    }
    
    public Plant getPlant() {
        ArrayList<Plant> plantsList = currentTile.getPlantsList(); 
        
        for (Plant plant : plantsList) {
            if (getRectangle().intersects(plant.getBounds())) {
                return plant;
            }
        }
        return null;
    }
    
    // OTHERS
    public void update() {
        switch (entity.getDirection()) {
            case 0:
                moveUp(entity.getX(), entity.getY());
                break;
            case 1:
                moveRight(entity.getX(), entity.getY());
                break;
            case 2:
                moveDown(entity.getX(), entity.getY());
                break;
            case 3:
                moveLeft(entity.getX(), entity.getY());
                break;
            default:
                break;
        }
    }

    public void moveLeft(int newX, int newY) {
        x = newX - (entity.getWidth()) / 3;
        y = newY;
        width = entity.getWidth() / 3;
        height = entity.getHeight();

        rectangle.setSize(width, height);
        rectangle.setLocation(x, y);
    }

    public void moveRight(int newX, int newY) {
        x = newX + entity.getWidth();
        y = newY;
        width = entity.getWidth() / 3;
        height = entity.getHeight();

        rectangle.setSize(width, height);
        rectangle.setLocation(x, y);
    }

    public void moveUp(int newX, int newY) {
        x = newX;
        y = newY - (entity.getHeight() / 3);
        width = entity.getWidth();
        height = entity.getHeight() / 3;

        rectangle.setSize(width, height);
        rectangle.setLocation(x, y);
    }

    public void moveDown(int newX, int newY) {
        x = newX;
        y = newY + entity.getHeight();
        width = entity.getWidth();
        height = entity.getHeight() / 3;

        rectangle.setSize(width, height);
        rectangle.setLocation(x, y);
    }
}
