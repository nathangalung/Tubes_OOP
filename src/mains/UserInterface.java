package src.mains;

import java.awt.FontMetrics;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.HashMap;
import java.util.ConcurrentModificationException;

// import src.entities.plants.Plant;
// import src.entities.zombies.Zombie;
import src.mains.menus.*;
import src.mains.panels.*;
import src.maps.Map;

public class UserInterface {
    public static UserInterface ui = new UserInterface();
    
    private static Map map;

    // Attributes
    // private static Map<Plant, Point> plantsListInventory = new HashMap<>();
    // private static Map<Plant, Point> plantsListInventoryDeck = new HashMap<>();
    // private static Map<Plant, Point> plantsListPlayDeck = new HashMap<>();
    // private static Map<Plant, Point> plantsListPlay = new HashMap<>();
    // private static Map<Zombie, Point> zombiesListPlay = new HashMap<>(); 
    
    // User Interface States
    private static boolean viewingMap = true;
    private static boolean viewingFlag = false;
    private static boolean viewingGamePause = false;
    private static boolean viewingGameWin = false;
    private static boolean viewingGameLose = false;
    private static boolean viewingGameSave = false;

    //ONLY FOR DEBUGGING
    private static boolean debug = false;

    // CONSTRUCTOR
    public UserInterface() {
    }

    public static void init(Map map) {
        viewingMap = true;
        viewingFlag = false;
        viewingGamePause = false;
        viewingGameWin = false;
        viewingGameLose = false;
        viewingGameSave = false;

        UserInterface.map = map;
        // UserInterface.currentMap.setIsAddingPlant();
    }

    // GETTERS
    public static UserInterface getInstance() {
        return ui;
    }

    public static Map getMap() {
        return map;
    }

    // public static Tile getTile() {
    //     return getTile;
    // }

    // public static Plant get() {
    //     return currentPlant;
    // }

    // public static Zombie getCurrentZombie() {
    //     return currentZombie;
    // }

    public static boolean isViewingMap() {
        return viewingMap;
    }

    public static boolean isViewingFlag() {
        return viewingFlag;
    }

    public static boolean isViewingGamePause() {
        return viewingGamePause;
    }

    public static boolean isViewingGameWin() {
        return viewingGameWin;
    }

    public static boolean isViewingGameLose() {
        return viewingGameLose;
    }

    public static boolean isViewingGameSave() {
        return viewingGameSave;
    }

    // // SETTERS
    // public static void setCurrentSim(Plant plant) {
    //     currentPlant = plant;
    //     cur = currentPlant.;
    // }

    public static void setViewingMap() {
        viewingMap = !viewingMap;
    }

    public static void setViewingFlag() {
        viewingFlag = !viewingFlag;
    }

    public static void setViewingGamePause() {
        viewingGamePause = !viewingGamePause;
    }

    public static void setViewingGameWin() {
        viewingGameWin = !viewingGameWin;
    }

    public static void setViewingGameLose() {
        viewingGameLose = !viewingGameLose;
    }

    public static void setViewingGameSave() {
        if (isViewingGamePause()) setViewingGamePause();
        if (isViewingGameWin()) setViewingGameWin();
        if (isViewingGameLose()) setViewingGameLose();
        viewingGameSave = !viewingGameSave;
    }

    // ONLY FOR DEBUGGING
    public static boolean isDebug() {
        return debug;
    }

    public static void debug() {
        debug = !debug;
    }

    // OTHERS
    // public void reset() {
    //     currentMap.reset();
    // }

    public static void update() {
    //     updatePlantsListGame();
    //     updateZombiesListGame();

    //     if (viewingFlag) {
    //         SaveMenu.update();
    //     }

        if (isViewingGamePause()) {
            GamePauseMenu.update();
        }

        if (isViewingGameWin()) {
            GameWinMenu.update();
        }

        if (isViewingGameLose()) {
            GameLoseMenu.update();
        }
    }
    
    public static void draw(Graphics2D g) {

        if (viewingFlag) {
        }

        if (isViewingGamePause()) GamePauseMenu.draw(g);

        if (isViewingGameWin()) GameWinMenu.draw(g);

        if (isViewingGameLose()) GameLoseMenu.draw(g);

        // if (viewingGameSave()) GameSaveMenu.draw(g);
    }

    // private static void updatePlantsListGame() {
    //     Map map = UserInterface.getMap();
    //     ArrayList<Plant> plantsListGame = map.getplantsListGame();
    //     try {
    //         for (Plant plant : plantsListGame) {
    //             if (plant.getHealth() > 0) {
    //                 continue;
    //             }
    //             if (plant.getHealth() <= 0) {
    //                 plant.setHealth(0);
    //                 plantsListGame.remove(plant);
    //             }
    //         }
    //     }
    //     catch (ConcurrentModificationException cme) {
    //     }
    // }

    // private static void updateZombiesListGame() {
    //     Map map = UserInterface.getMap();
    //     ArrayList<Zombie> zombiesListGame = map.getzombiesListGame();
    //     try {
    //         for (Zombie zombie : zombiesListGame) {
    //             if (zombie.getHealth() > 0) {
    //                 continue;
    //             }
    //             if (zombie.getHealth() <= 0) {
    //                 zombie.setHealth(0);
    //                 zombiesListGame.remove(zombie);
    //             }
    //         }
    //     }
    //     catch (ConcurrentModificationException cme) {
    //     }
    // }

    public static void drawCenteredText(Graphics2D g, BufferedImage image, int x, int y, String str, Font f) {
        String text = str;
        Font font = f;
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int centerX = (image.getWidth() - textWidth) / 2;

        g.drawString(str, x + centerX, y);
    }

    public static void drawCenteredText(Graphics2D g, BufferedImage image, int x, int y, int offset, String str, int size) {
        Font f = new Font("Monsterrat", Font.BOLD, size);
        g.setFont(f);
        FontMetrics metrics = g.getFontMetrics(f);
        int textWidth = metrics.stringWidth(str);
        int centerX = (image.getWidth() - textWidth) / 2;

        g.drawString(str, x + centerX + offset, y);
    }
}
