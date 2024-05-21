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

public class Map {
    // Attributes
    private int[][] map = new int[64][64];
    private ArrayList<Plant> plantsList;
    private ArrayList<Zombie> zombiesList;
    
    // State of the world (is adding a house or selecting a house to visit)
    private boolean isEditingMap;
    private boolean isAddingPlant;
    private CollisionHandler collisionHandler;
    private Plant removablePlant = null;
    private Plant selectedPlant = null;

    private int centerX = Consts.WIDTH / 2 - 3 * Consts.SCALED_TILE;
    private int centerY = Consts.HEIGHT / 2 - 3 * Consts.SCALED_TILE;

    // Images of the world
    private BufferedImage[] images;
    
    // Cursor position
    private Cursor cursor;

    private int viewableGrid = (Consts.TILE_SIZE * 32) - 1;
    private int topLeftX = 26;
    private int topLeftY = 26;

    // Bounds for each quarter
    private int lowerBoundsX, upperBoundsX;
    private int lowerBoundsY, upperBoundsY;

    // Constructor 
    public Map() {
        // Attributes
        this.plantsList = new ArrayList<>();
        this.zombiesList = new ArrayList<>();
        this.isEditingMap = false;

        // Load the images of the world
        this.images = ImageLoader.loadMap();

        for (int y = 0 ; y < 64 ; y++) {
            for (int x = 0 ; x < 64 ; x++) {
                map[y][x] = 0;
            }
        }
    }

    public int getMap(int x, int y) {
        return map[y][x];
    }

    public ArrayList<Plant> getPlantsList() {
        return plantsList;
    }

    public boolean isEditingMap() {
        return isEditingMap;
    }

    public boolean isAddingPlant() {
        return isAddingPlant;
    }

    public ArrayList<Zombie> getZombiesList() {
        return zombiesList;
    }

    public void setIsEditingMap() {
        this.isEditingMap = !this.isEditingMap;
    }

    public void setIsAddingPlant() {
        this.isAddingPlant = !this.isAddingPlant;
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

    public void addPlant(Plant plant) {
        setIsEditingMap();
        removablePlant = plant;
        collisionHandler = new CollisionHandler(removablePlant, this);
    }

    public void editPlant(Plant plant) {
        removablePlant = plant;
        plantsList.remove(plant);
        collisionHandler = new CollisionHandler(removablePlant, this);
    }

    public void removePlant(Plant plant) {
        plantsList.remove(plant);
    }

    public void addZombie(Zombie zombie) {
        zombiesList.add(zombie);
    }

    public void removeZombie(Zombie zombie) {
        zombiesList.remove(zombie);
    }

    public void selectPlant() {
        setIsEditingMap();
        try {
            for (Plant plant : plantsList) {
                selectedPlant = plant;

                return;
            }
            setIsEditingMap();
        }
        catch (ConcurrentModificationException e) {}
    }

    // Others
    public void reset() {
        plantsList.clear();
        zombiesList.clear();
        isEditingMap = false;
        isAddingPlant = false;
        selectedPlant = null;
        removablePlant = null;
    }

    public void update() {
        if (UserInterface.isviewingGamePause()) return;
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_ESCAPE)) {
            if (GamePanel.isCurrentState("Game: Play")) {
                GamePanel.gameState = "Game: Pause";
            }
            else if (GamePanel.isCurrentState("Game: Pause")) {
                GamePanel.gameState = "Game: Play";
            }
            UserInterface.isViewingMap();
        }
        updateSelectedPlant();

        // updateUnaddedPlant();
    }

    public void draw(Graphics2D g) {
        // Draw the world in quarters with the size of each quarter of 32 x 32
        drawMap(g);

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
        if (isEditingMap && removablePlant == null) {
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
    // private void updateUnaddedPlant() {
    //     if (isEditingMap && removablePlant != null) {
    //         boolean inCollision = false;
    //         boolean isCollidingWithZombie = false;

    //         inCollision = collisionHandler.isCollision(removablePlant.getX(), removablePlant.getY());
    //         isCollidingWithZombie = collisionHandler.isCollidingWithZombie(removablePlant.getX(), removablePlant.getY(), listOfZombies);
            
    //         removablePlant.move(collisionHandler);
    //         removablePlant.updateBounds();

    //         // To check if a wall is already connected to a room

    //         // To rotate the door
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_R)) {
    //             if (removablePlant instanceof Door) {
    //                 Door door = (Door) removablePlant;
    //             }
                
    //             if (removablePlant instanceof Toilet) {
    //                 Toilet toilet = (Toilet) removablePlant;
    //             }
    //         }
                
    //         // Add the plant if enter is pressed and plant is not in collision with another plant
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER) && (!inCollision && !isWallOccupied && !isCollidingWithZombie)) {
    //             plantsList.add(removablePlant);
    //             removablePlant = null;
    //             setIsEditingMap();
    //         }

    //         // Cancel adding or moving an plant if escape is pressed and add plant into Zombie inventory
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_ESCAPE)) {
    //             if (!(removablePlant instanceof Door)) {
    //                 Zombie currentZombie = UserInterface.getCurrentZombie();
    //             }
    //             removablePlant = null;
    //             setIsEditingMap();
    //         }
    //     }
    // }

    private void drawMap(Graphics2D g) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 11; x++) {
                int tileX = centerX + (x * Consts.SCALED_TILE);
                int tileY = centerY + (y * Consts.SCALED_TILE) - Consts.OFFSET_Y;
                if (x == 0) {
                    g.drawImage(images[0], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
                }
                else if (x == 10) {
                    g.drawImage(images[3], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
                }
                else if (y >= 2 && y <= 4) {
                    g.drawImage(images[2], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
                }
                else {
                    g.drawImage(images[1], tileX, tileY, Consts.SCALED_TILE, Consts.SCALED_TILE, null);
                
                }
            }
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

    private void drawPlantSelector(Graphics2D g) {
        try {
            if (isEditingMap && removablePlant == null) {
                int plantWidth = (int) selectedPlant.getBounds().getWidth();
                int plantHeight = (int) selectedPlant.getBounds().getHeight();
                
                g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
                g.fillRect(selectedPlant.getX(), selectedPlant.getY(), plantWidth, plantHeight);
            }
        }
        catch (NullPointerException e) {}
    }

    private void drawSelectedPlant(Graphics2D g) {
        try {
            if (isEditingMap && removablePlant != null) {
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