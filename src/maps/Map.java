package src.maps;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import src.mains.Consts;
import src.mains.panels.InventoryPanel;
import src.assets.ImageLoader;
import src.mains.panels.PanelHandler;
// import src.entities.zombies.Zombie;
import src.mains.KeyHandler;
import src.mains.UserInterface;
import src.mains.panels.GamePanel;
// import src.entities.handlers.CollisionHandler;
// import src.entities.plants.Plant;

public class Map {
    // Attributes
    private int[][] map = new int[64][64];
    // private ArrayList<Plant> plantsList;
    // private ArrayList<Zombie> zombiesList;
    private static int selectedBox = 0;
    private static int selectedTile = 100;
    // State of the world (is adding a house or selecting a house to visit)
    private boolean isAddingPlant = false;
    private boolean isRemovingPlant = false;
    private int[] plantsDeck = InventoryPanel.plantsDeck;
    private int[] checkTile;

    // private CollisionHandler collisionHandler;
    // private Plant removablePlant = null;
    // private Plant selectedPlant = null;


    // Images of the world
    private BufferedImage[] images;
    
    // Cursor position
    // private Cursor cursor;


    // Constructor 
    public Map() {
        checkTile = new int[54];
        for (int i = 0; i < 54; i++) {
            checkTile[i] = 0;
        }
        // Attributes
        // this.plantsList = new ArrayList<>();
        // this.zombiesList = new ArrayList<>();
        this.isAddingPlant = false;
        this.isRemovingPlant = false;

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

    // public ArrayList<Plant> getPlantsList() {
    //     return plantsList;
    // }

    public boolean isAddingPlant() {
        return isAddingPlant;
    }

    public boolean isRemovingPlant() {
        return isRemovingPlant;
    }

    // public ArrayList<Zombie> getZombiesList() {
    //     return zombiesList;
    // }

    public void setIsAddingPlant() {
        isAddingPlant = !isAddingPlant;
        if (isAddingPlant()) {
            selectedBox = 100;
            selectedTile = 0;
        }
        else {
            selectedBox = 0;
            selectedTile = 100;
        }
    }

    public void setIsRemovingPlant() {
        isRemovingPlant = !isRemovingPlant;
        if (isRemovingPlant()) {
            selectedBox = 100;
            selectedTile = 0;
        }
        else {
            selectedBox = 0;
            selectedTile = 100;
        }
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

    // public void addPlant(Plant plant) {
    //     setIsEditingMap();
    //     removablePlant = plant;
    //     collisionHandler = new CollisionHandler(removablePlant, this);
    // }

    // public void editPlant(Plant plant) {
    //     removablePlant = plant;
    //     plantsList.remove(plant);
    //     collisionHandler = new CollisionHandler(removablePlant, this);
    // }

    // public void removePlant(Plant plant) {
    //     plantsList.remove(plant);
    // }

    // public void addZombie(Zombie zombie) {
    //     zombiesList.add(zombie);
    // }

    // public void removeZombie(Zombie zombie) {
    //     zombiesList.remove(zombie);
    // }

    // public void selectPlant() {
    //     setIsEditingMap();
    //     try {
    //         for (Plant plant : plantsList) {
    //             selectedPlant = plant;

    //             return;
    //         }
    //         setIsEditingMap();
    //     }
    //     catch (ConcurrentModificationException e) {}
    // }

    // // Others
    // public void reset() {
    //     plantsList.clear();
    //     zombiesList.clear();
    //     isEditingMap = false;
    //     isAddingPlant = false;
    //     selectedPlant = null;
    //     removablePlant = null;
    // }

    private void boxPressed() {
        if (selectedBox == 0) {
            setIsAddingPlant();
        }

        if (selectedBox == 1) {
            setIsAddingPlant();
        }

        if (selectedBox == 2) {
            setIsAddingPlant();
        }

        if (selectedBox == 3) {
            setIsAddingPlant();
        }

        if (selectedBox == 4) {
            setIsAddingPlant();
        }

        if (selectedBox == 5) {
            setIsAddingPlant();
        }
        
        if (selectedBox == 6) {
            PanelHandler.switchPanel(GamePanel.getInstance(), GamePanel.getInstance());
            GamePanel.gameState = "Game: Pause";
            UserInterface.setViewingGamePause();
        }

        if (selectedBox == 7) {
            setIsRemovingPlant();
        }
    }

    private void tilePressed() {
        if (selectedTile >= 0 && selectedTile < 18) {
            if (isAddingPlant()) {
                if (checkTile[selectedTile] == 0) checkTile[selectedTile] = 1;
                setIsAddingPlant();
            }
            else {
                if (checkTile[selectedTile] == 1) checkTile[selectedTile] = 0;
                setIsRemovingPlant();
            }
        }
        if (selectedTile >= 18 && selectedTile < 36) {
            if (isAddingPlant()) {
                if (checkTile[selectedTile] == 0) checkTile[selectedTile] = 1;
                setIsAddingPlant();
            }
            else {
                if (checkTile[selectedTile] == 1) checkTile[selectedTile] = 0;
                setIsRemovingPlant();
            }
        }
        if (selectedTile >= 36 && selectedTile < 54) {
            if (isAddingPlant()) {
                if (checkTile[selectedTile] == 0) checkTile[selectedTile] = 1;
                setIsAddingPlant();
            }
            else {
                if (checkTile[selectedTile] == 1) checkTile[selectedTile] = 0;
                setIsRemovingPlant();
            }
        }
    }

    public void update() {
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)) {
            if (!isAddingPlant() && !isRemovingPlant()) {
                boxPressed();
            }
            else {
                tilePressed();
            }
        }

        if (!isAddingPlant() && !isRemovingPlant()) {
            int newSelectedBox = selectedBox;
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP) || KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
                if (selectedBox == 7) {
                    newSelectedBox = 0;
                }
                else {
                    newSelectedBox = 7;
                }
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT)) {
                if (selectedBox == 6) {
                    newSelectedBox = 0;
                }
                else if (selectedBox == 7) {
                    newSelectedBox = 7;
                }
                else {
                    newSelectedBox++;
                }
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
                if (selectedBox == 0) {
                    newSelectedBox = 6;
                }
                else if (selectedBox == 7) {
                    newSelectedBox = 7;
                }
                else {
                    newSelectedBox--;
                }
            }

            if (newSelectedBox >= 0 && newSelectedBox < 8) {
                selectedBox = newSelectedBox;
            }
        }
        else {
            int newSelectedTile = selectedTile;
            if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
                if (selectedTile >= 0 && selectedTile < 9) {
                    newSelectedTile += 45;
                }
                else {
                    newSelectedTile -= 9;
                }
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT)) {
                if ((selectedTile + 1) % 9 == 0) {
                    newSelectedTile -= 8;
                }
                else {
                    newSelectedTile++;
                }
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
                if (selectedTile >= 45 && selectedTile < 54) {
                    newSelectedTile -= 45;
                }
                else {
                    newSelectedTile += 9;
                }
            }

            if (KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
                if ((selectedTile) % 9 == 0) {
                    newSelectedTile += 8;
                }
                else {
                    newSelectedTile--;
                }
            }

            if (newSelectedTile >= 0 && newSelectedTile < 54){
                selectedTile = newSelectedTile;
            }
        }

        if (UserInterface.isviewingGamePause()) return;
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_ESCAPE)) {
            if (GamePanel.isCurrentState("Game")) {
                GamePanel.gameState = "Game: Pause";
            }
            else if (GamePanel.isCurrentState("Game: Pause")) {
                GamePanel.gameState = "Game";
            }
            UserInterface.setViewingMap();
        }
        // updateSelectedPlant();

        // updateUnaddedPlant();
    }

    public void draw(Graphics2D g) {
        // Draw the world in quarters with the size of each quarter of 32 x 32
        drawMap(g);

        drawTile(g);

        // drawPlants(g);

        // drawZombies(g);

        // drawPlantSelector(g);

        // drawSelectedPlant(g);

        // if (UserInterface.isDebug()) {
        //     drawCollisionBox(g);
        // }
    }

    // private Plant findNearestplant(String direction) {
    //     Plant minPlant = null;
    //     int minDistance = Integer.MAX_VALUE;
    //     int distance = Integer.MAX_VALUE;
    //     int dx = 0;
    //     int dy = 0;

    //     for (Plant plant : plantsList) {
    //         if (plant == selectedPlant) {
    //             continue;
    //         }
            
    //         dx = plant.getX() - selectedPlant.getX();
    //         dy = plant.getY() - selectedPlant.getY();
    //         distance = (int) Math.sqrt((dx * dx) + (dy * dy));
            
    //         switch (direction) {
    //             case "up":
    //                 if (dy < 0 && distance < minDistance)  {
    //                     minDistance = distance;
    //                     minPlant = plant;
    //                 }
    //                 break;
    //             case "left":
    //                 if (dx < 0 && distance < minDistance) {
    //                     minDistance = distance;
    //                     minPlant = plant;
    //                 }
    //                 break;
    //             case "down":
    //                 if (dy > 0 && distance < minDistance) {
    //                     minDistance = distance;
    //                     minPlant = plant;
    //                 }
    //                 break;
    //             case "right":
    //                 if (dx > 0 && distance < minDistance) {
    //                     minDistance = distance;
    //                     minPlant = plant;
    //                 }
    //                 break;
    //             default:
    //                 break;
    //         }
    //     }

    //     if (minPlant == null) {
    //         return selectedPlant;
    //     }
    //     else {
    //         return minPlant;
    //     }
    // }

    // private void updateSelectedPlant() {
    //     if (isEditingMap && removablePlant == null) {
    //         // Find the nearest plant based on the WASD keys
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_W)) {
    //             selectedPlant = findNearestplant("up");
    //         }
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_A)) {
    //             selectedPlant = findNearestplant("left");
    //         }
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_S)) {
    //             selectedPlant = findNearestplant("down");
    //         }
    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_D)) {
    //             selectedPlant = findNearestplant("right");
    //         }

    //         if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)) {
    //             editPlant(selectedPlant);
    //         }
    //     }
    // }

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
        g.drawImage(images[0], 0, -20, null);
        g.drawImage(images[2], 25, 30, null);
        g.drawImage(images[3], 815, -10, null);
        g.drawImage(images[4], 1047, 30, null);
        g.drawImage(images[5], 1100, 30, null);
        g.drawImage(images[6], 25, 30, null);

        for (int i = 0; i < 36; i++) {
            if (i < 6) {
                g.drawImage(images[9], Consts.PINK_TILES[i].x, Consts.PINK_TILES[i].y, null);
                g.drawImage(images[12], Consts.BROWN_TILES[i].x, Consts.BROWN_TILES[i].y, null);
            }
            if (i < 18) g.drawImage(images[11], Consts.BLUE_TILES[i].x, Consts.BLUE_TILES[i].y, null);
            g.drawImage(images[10], Consts.GREEN_TILES[i].x, Consts.GREEN_TILES[i].y, null);
        }

        for (int i = 0; i < 6; i ++) {
            g.drawImage(images[plantsDeck[i] + 14], 195 + (i*100), 22, null);
        }

        for (int i = 0; i < 6; i ++) {
            if (selectedBox == i) g.drawImage(images[plantsDeck[i] + 34], 195 + (i*100), 22, null);
        }

        if (selectedBox == 6) g.drawImage(images[7], 1100, 30, null);
    }

    private void drawTile(Graphics2D g) {
        for (int i = 0; i < 54; i++) {
            if (selectedTile == i && i < 18) g.drawImage(images[13], Consts.GREEN_TILES[i].x, Consts.GREEN_TILES[i].y, null); 
            if (selectedTile == i && i >= 18 && i < 36) g.drawImage(images[13], Consts.BLUE_TILES[i-18].x, Consts.BLUE_TILES[i-18].y, null);
            if (selectedTile == i && i >= 36 && i < 54) g.drawImage(images[13], Consts.GREEN_TILES[i-18].x, Consts.GREEN_TILES[i-18].y, null);
        }
    }

    

    // private void drawPlants(Graphics2D g) {
    //     try {
    //         for (Plant plant : plantsList) {
    //             plant.draw(g, plant);
    //         }
    //     }
    //     catch (ConcurrentModificationException e) {}
    // }

    // private void drawZombies(Graphics2D g) {
    //     try {
    //         for (Zombie zombie: zombiesList) {
    //             zombie.draw(g, zombie);
    //         }
    //     }
    //     catch (ConcurrentModificationException e) {}
    // }

    // private void drawPlantSelector(Graphics2D g) {
    //     try {
    //         if (isEditingMap && removablePlant == null) {
    //             int plantWidth = (int) selectedPlant.getBounds().getWidth();
    //             int plantHeight = (int) selectedPlant.getBounds().getHeight();
                
    //             g.setColor(new Color(255, 0, 0, 64)); // Transparent red color
    //             g.fillRect(selectedPlant.getX(), selectedPlant.getY(), plantWidth, plantHeight);
    //         }
    //     }
    //     catch (NullPointerException e) {}
    // }

    // private void drawSelectedPlant(Graphics2D g) {
    //     try {
    //         if (isEditingMap && removablePlant != null) {
    //             removablePlant.draw(g, removablePlant);
    //         }
    //     }
    //     catch (NullPointerException e) {}
    // }

    // // ONLY FOR DEBUGGING
    // public void drawCollisionBox(Graphics2D g) {
    //     for (Plant plant : plantsList) {
    //         plant.drawCollisionBox(g);
    //     }
    // }
}