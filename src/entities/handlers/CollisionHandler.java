package src.entities.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;

import src.entities.*;
import src.entities.plants.Plant;
import src.entities.zombies.Zombie;
import src.mains.Consts;
import src.maps.Map;

public class CollisionHandler {
    private static Entity entity;
    private static Map currentMap;
    
    public CollisionHandler(Entity entity, Map map) {
        this.entity = entity;
        this.currentMap = map;
    }
    
    // public CollisionHandler(Interactables moveableObject, Map map) {
    //     //TODO Auto-generated constructor stub
    // }

    public static boolean isCollision(int x, int y) {
        Rectangle newEntityRectangle;

        if (entity instanceof Zombie) {
        // Extend the width of the plant's collision box by one tile to the right
            newEntityRectangle = new Rectangle(x + 8, y + 15, entity.getWidth() - 16, entity.getHeight() - 16);
        }
        else if (entity instanceof Bullet) {
            newEntityRectangle = new Rectangle(x + 8, y + 15, entity.getWidth(), entity.getHeight());
        }
        else if (entity instanceof Plant) {
            newEntityRectangle = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        }

        ArrayList<Plant> plantsList = currentMap.getPlantsList();
        for (Plant plant : plantsList) {
            if (newEntityRectangle.intersects(plant.getBounds())) {
                return true;
            }
        }

        ArrayList<Zombie> zombiesList = currentMap.getZombiesList();
        for (Zombie zombie : zombiesList) {
            if (newEntityRectangle.intersects(zombie.getBounds())) {
                return true;
            }
        }
        
        return false;
    }

    public boolean isCollidingWithPlant(int x, int y, ArrayList<Plant> plantsList) {
        Rectangle newEntityRectangle;
        Rectangle plantRectangle;

        newEntityRectangle = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        for (Plant plant : plantsList) {
            plantRectangle = new Rectangle(plant.getX() + 8, plant.getY() + 15, plant.getWidth() - 16, plant.getHeight() - 16);  
            if (newEntityRectangle.intersects(plantRectangle)) {
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


