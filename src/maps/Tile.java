package src.maps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import src.mains.Consts;
import src.assets.AssetsLoader;
import src.assets.ImageLoader;
import src.entities.zombies.Zombie;
import src.mains.KeyHandler;
import src.mains.UserInterface;
import src.mains.panels.GamePanel;
import src.mains.panels.PanelHandler;
import src.mains.times.GameTime;
import src.world.House;
import src.world.Room;
import src.entities.handlers.CollisionHandler;
import src.entities.plants.Plant;

public class Tile {
    // Attributes
    private ArrayList<Plant> plantsList;
    private ArrayList<Zombie> zombiesList;
    
    // State of the world (is adding a house or selecting a house to visit)
    private boolean isEditingTile;
    private CollisionHandler collisionHandler;
    private Plant removablePlant = null;
    private Plant selectedPlant = null;

    private int centerX = Consts.WIDTH / 2 - 3 * Consts.SCALED_TILE;
    private int centerY = Consts.HEIGHT / 2 - 3 * Consts.SCALED_TILE;

    // Images of the world
    private BufferedImage[] images;
    
    // Cursor position
    private Cursor cursor;

    // Constructor 
    public Map() {
        // Attributes
        this.plantsList = new ArrayList<>();
        this.zombiesList = new ArrayList<>();
        this.isEditingTile = false;

        // Load the images of the world
        this.images = ImageLoader.loadMap();
    }
    public ArrayList<Plant> getPlantsList() {
        return plantsList;
    }

    public boolean isEditingTile() {
        return isEditingTile;
    }

    public ArrayList<Zombie> getZombiesList() {
        return zombiesList;
    }

    // Load the initial state of the map
    

    // public ArrayList<Plant> getplantsListGame() {
    //     return plantsListGame;
    // }

    // public Plant getPlant(int index) {
    //     return plantsListGame.get(index);
    // }

    // public ArrayList<Zombie> getListOfZombiesGame() {
    //     return listOfZombiesGame;
    // }

// public Zombie getZombie(int index) {
//     return zombiesList.get(index);
// }


    public Cursor getCursor() {
        return cursor;
    }

    public void addPlant(Plant plant) {
        changeIsEditingTile();
        removablePlant = plant;
        collisionHandler = new CollisionHandler(removablePlant, this);
    }

    public void editPlant(Plant plant) {
        removablePlant = plant;
        plantsList.remove(plant);
        collisionHandler = new CollisionHandler(removablePlant, this);
    }

    public void addZombie(Zombie zombie) {
        zombiesList.add(zombie);
    }

    public void removePlant(Plant plant) {
        plantsList.remove(plant);
    }

    public void changeIsEditingTile() {
        this.isEditingTile = !this.isEditingTile;
    }

    public void selectPlant() {
        changeIsEditingTile();
        try {
            for (Plant plant : plantsList) {
                selectedPlant = plant;

                return;
            }
            changeIsEditingTile();
        }
        catch (ConcurrentModificationException e) {}
    }

    // Others
    public void update() {
        updateSelectedPlant();

        updateUnaddedPlant();
    }

    public void draw(Graphics2D g) {
        // Draw the world in quarters with the size of each quarter of 32 x 32
        drawTiles(g);

        drawPlants(g);

        drawZombies(g);

        drawPlantSelector(g);

        drawSelectedPlant(g);

        if (UserInterface.isDebug()) {
            drawCollisionBox(g);
        }
    }

    private Plant findNearestplant(String direction) {
        Plant minPlant = null;
        int minDistance = Integer.MAX_VALUE;
        int distance = Integer.MAX_VALUE;
        int dx = 0;
        int dy = 0;

        for (Plant plant : plantsList) {
            if (plant == selectedPlant) {
                continue;
            }
            
            dx = plant.getX() - selectedPlant.getX();
            dy = plant.getY() - selectedPlant.getY();
            distance = (int) Math.sqrt((dx * dx) + (dy * dy));
            
            switch (direction) {
                case "up":
                    if (dy < 0 && distance < minDistance)  {
                        minDistance = distance;
                        minPlant = plant;
                    }
                    break;
                case "left":
                    if (dx < 0 && distance < minDistance) {
                        minDistance = distance;
                        minPlant = plant;
                    }
                    break;
                case "down":
                    if (dy > 0 && distance < minDistance) {
                        minDistance = distance;
                        minPlant = plant;
                    }
                    break;
                case "right":
                    if (dx > 0 && distance < minDistance) {
                        minDistance = distance;
                        minPlant = plant;
                    }
                    break;
                default:
                    break;
            }
        }

        if (minPlant == null) {
            return selectedPlant;
        }
        else {
            return minPlant;
        }
    }

    private void updateSelectedPlant() {
        if (isEditingTile && removablePlant == null) {
            // Find the nearest plant based on the WASD keys
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_W)) {
                selectedPlant = findNearestplant("up");
            }
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_A)) {
                selectedPlant = findNearestplant("left");
            }
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_S)) {
                selectedPlant = findNearestplant("down");
            }
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_D)) {
                selectedPlant = findNearestplant("right");
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)) {
                editPlant(selectedPlant);
            }
        }
    }

    // TO - DO !!! : Integrate with inventory
    private void updateUnaddedplant() {
        if (isEditingTile && removablePlant != null) {
            boolean inCollision = false;
            boolean isCollidingWithZombie = false;
            boolean isWallOccupied = false;

            inCollision = collisionHandler.isCollision(removablePlant.getX(), removablePlant.getY());
            isCollidingWithZombie = collisionHandler.isCollidingWithZombie(removablePlant.getX(), removablePlant.getY(), listOfZombies);
            
            removablePlant.move(collisionHandler);
            removablePlant.updateBounds();

            // To check if a wall is already connected to a room

            // To rotate the door
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_R)) {
                if (removablePlant instanceof Door) {
                    Door door = (Door) removablePlant;
                }
                
                if (removablePlant instanceof Toilet) {
                    Toilet toilet = (Toilet) removablePlant;
                }
            }
                
            // Add the plant if enter is pressed and plant is not in collision with another plant
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER) && (!inCollision && !isWallOccupied && !isCollidingWithZombie)) {
                plantsList.add(removablePlant);
                removablePlant = null;
                changeIsEditingTile();
            }

            // Cancel adding or moving an plant if escape is pressed and add plant into Zombie inventory
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_ESCAPE)) {
                if (!(removablePlant instanceof Door)) {
                    Zombie currentZombie = UserInterface.getCurrentZombie();
                }
                removablePlant = null;
                changeIsEditingTile();
            }
        }
    }

    private void drawTiles(Graphics2D g) {
        for (int y = 0; y < 6; y++) {
            int tileX = centerX + (x * Consts.SCALED_TILE);
            int tileY = centerY + (y * Consts.SCALED_TILE) - Consts.OFFSET_Y;
            g.drawImage(images[0], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
            for (int x = 0; x < 6; x++) {
                g.drawImage(images[1], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
            }
            g.drawImage(images[3], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
        }
    }

    private void drawPlants(Graphics2D g) {
        try {
            for (Plant plant : plantsList) {
                plant.draw(g, plant);
            }
        }
        catch (ConcurrentModificationException e) {}
    }

    private void drawZombies(Graphics2D g) {
        try {
            for (Zombie zombie: zombiesList) {
                zombie.draw(g, zombie);
            }
        }
        catch (ConcurrentModificationException e) {}
    }

    private void drawplantSelector(Graphics2D g) {
        try {
            if (isEditingTile && removablePlant == null) {
                int plantWidth = (int) selectedPlant.getBounds().getWidth();
                int plantHeight = (int) selectedPlant.getBounds().getHeight();
                
                g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
                g.fillRect(selectedPlant.getX(), selectedPlant.getY(), plantWidth, plantHeight);
            }
        }
        catch (NullPointerException e) {}
    }

    private void drawselectedPlant(Graphics2D g) {
        try {
            if (isEditingTile && removablePlant != null) {
                removablePlant.draw(g, removablePlant);
            }
        }
        catch (NullPointerException e) {}
    }

    // ONLY FOR DEBUGGING
    public void drawCollisionBox(Graphics2D g) {
        for (Plant plant : plantsList) {
            plant.drawCollisionBox(g);
        }
    }
}