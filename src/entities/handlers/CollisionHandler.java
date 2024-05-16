package src.entities.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;

import entities.plants.Plant;
import entities.zombies.Zombie;
import src.entities.interactables.Interactables;
import src.entities.sim.Sim;
import src.main.Consts;

public class CollisionHandler {
    private Entity entity;
    
    public CollisionHandler(Entity entity) {
        this.entity = entity;
    }
    
    public boolean isCollision(int x, int y) {
        Rectangle newEntity;
        int tileWidth = 16; // Assuming the width of a tile is 16 pixels

        if (entity instanceof Plant) {
        // Extend the width of the plant's collision box by one tile to the right
            newEntity = new Rectangle(x + 8, y + 15, entity.getWidth() - 16 + tileWidth, entity.getHeight() - 16);
        }
        else {
            newEntity = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        }

        ArrayList<Interactables> listOfObjects = currentRoom.getListOfObjects();
        for (Interactables object : listOfObjects) {
            if (newEntity.intersects(object.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithPlant(int x, int y, ArrayList<Zombie> listOfZombies) {
        Rectangle newEntity;
        Rectangle zombie;

        newEntity = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        for (Sim sim : listOfSims) {
            Sim = new Rectangle(sim.getX() + 8, sim.getY() + 15, sim.getWidth() - 16, sim.getHeight() - 16);  
            if (newEntity.intersects(Sim)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCollidingWithZombie(int x, int y, ArrayList<Sim> listOfSims) {
        Rectangle newEntity;
        Rectangle Sim;

        newEntity = new Rectangle(x, y, entity.getWidth(), entity.getHeight());
        for (Sim sim : listOfSims) {
            Sim = new Rectangle(sim.getX() + 8, sim.getY() + 15, sim.getWidth() - 16, sim.getHeight() - 16);  
            if (newEntity.intersects(Sim)) {
                return true;
            }
        }
        return false;
    }
}


