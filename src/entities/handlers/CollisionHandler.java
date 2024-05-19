package src.entities.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;

import src.entities.Entity;
import src.entities.plants.Plant;
import src.entities.zombies.Zombie;
import src.mains.Consts;
import src.maps.Map;

public class CollisionHandler {
    private Entity entity;
    private Map currentTile;
    
    public CollisionHandler(Entity entity, Map tile) {
        this.entity = entity;
        this.currentTile = tile;
    }
    
    public boolean isCollision(int x, int y) {
        Rectangle newEntityRectangle;

        int tileWidth = 16; // Assuming the width of a tile is 16 pixels

        if (entity instanceof Zombie) {
        // Extend the width of the plant's collision box by one tile to the right
            newEntityRectangle = new Rectangle(x + 8, y + 15, entity.getWidth() - 16 + tileWidth, entity.getHeight() - 16);
        }
        else {
            newEntityRectangle = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        }

        ArrayList<Plant> plantsList = currentTile.getPlantsList();
        for (Plant plant : plantsList) {
            if (newEntityRectangle.intersects(plant.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithPlant(int x, int y, ArrayList<Zombie> zombiesList) {
        Rectangle newEntityRectangle;
        Rectangle zombieRectangle;

        newEntityRectangle = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        for (Zombie zombie : zombiesList) {
            zombieRectangle = new Rectangle(zombie.getX() + 8, zombie.getY() + 15, zombie.getWidth() - 16, zombie.getHeight() - 16);  
            if (newEntityRectangle.intersects(zombieRectangle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithZombie(int x, int y, ArrayList<Zombie> zombiesList) {
        Rectangle newEntityRectangle;
        Rectangle zombiRectangle;

        newEntityRectangle = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        for (Zombie zombie : zombiesList) {
            zombiRectangle = new Rectangle(zombie.getX() + 8, zombie.getY() + 15, zombie.getWidth() - 16, zombie.getHeight() - 16);  
            if (newEntityRectangle.intersects(zombiRectangle)) {
                return true;
            }
        }
        return false;
    }
}


