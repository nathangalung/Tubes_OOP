package src.mains;

import java.awt.FontMetrics;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.Map;
import java.util.HashMap;
import java.util.ConcurrentModificationException;

import src.entities.plants.Plant;
import src.entities.zombies.Zombie;
import src.mains.menus.*;
import src.mains.panels.*;

public class UserInterface {
    public static UserInterface ui = new UserInterface();
    
    // Attributes
    private static Map<Plant, Point> plantsListInventory = new HashMap<>();
    private static Map<Plant, Point> plantsListInventoryDeck = new HashMap<>();
    private static Map<Plant, Point> plantsListPlayDeck = new HashMap<>();
    private static Map<Plant, Point> plantsListPlay = new HashMap<>();
    private static Map<Zombie, Point> zombiesListPlay = new HashMap<>(); 
    
    // User Interface States
    private static boolean viewingMap = true;
    private static boolean viewingFlag = false;
    private static boolean viewingGamePause = false;
    private static boolean viewingGameWin = false;
    private static boolean viewingGameLose = false;

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

        UserInterface.currentMap = map;
        UserInterface.currentMap.setIsAddingPlant();
    }

    // GETTERS
    public static UserInterface getInstance() {
        return ui;
    }

    public static Tile getTile() {
        return getTile;
    }

    public static Plant get() {
        return currentPlant;
    }

    public static Zombie getCurrentZombie() {
        return currentZombie;
    }

    public static boolean isViewingMap() {
        return viewingMap;
    }

    public static boolean isViewingFlag() {
        return viewingFlag;
    }

    public static boolean isviewingGamePause() {
        return viewingGamePause;
    }

    public static boolean isviewingGameWin() {
        return viewingGameWin;
    }

    public static boolean isviewingGameLose() {
        return viewingGameLose;
    }

    // // SETTERS
    // public static void setCurrentSim(Plant plant) {
    //     currentPlant = plant;
    //     cur = currentPlant.;
    // }

    public static void setViewingMap() {
        viewingMap = !viewingMap;
        currentMap.reset();
    }

    public static void setViewingFlag() {
        viewingFlag = !viewingFlag;
    }

    public static void setviewingGamePause() {
        viewingGamePause = !viewingGamePause;
    }

    public static void setviewingGameWin() {
        viewingGameWin = !viewingGameWin;
    }

    public static void setviewingGameLose() {
        viewingGameLose = !viewingGameLose;
    }

    // ONLY FOR DEBUGGING
    public static boolean isDebug() {
        return debug;
    }

    public static void debug() {
        debug = !debug;
    }

    // OTHERS
    public void reset() {
        currentMap.reset();
    }

    public static void update() {
        updateListOfPlantsGame();
        updateListOfZombiesGame();

        if (viewingFlag) {
            FlagMenu.update();
        }

        if (viewingGamePause) {
            GamePauseMenu.update();
        }

        if (viewingGameWin) {
            GameWinMenu.update();
        }

        if (viewingGameLose) {
            GameLoseMenu.update();
        }
    }
    
    public static void draw(Graphics2D g) {
        currentSimInventory.draw(g);

        if (viewingFlag) {
            FlagMenu.draw(g);
        }

        if (viewingGamePause) {
            GamePauseMenu.draw(g);
        }

        if (viewingGameWin) {
            GameWinMenu.draw(g);
        }

        if (viewingGameLose) {
            GameLoseMenu.draw(g);
        }
    }

    private static void updateListOfPlantsGame() {
        Map map = UserInterface.getMap();
        ArrayList<Plant> listOfPlantsGame = map.getListOfPlantsGame();
        try {
            for (Plant plant : listOfPlantsGame) {
                if (plant.getHealth() > 0) {
                    continue;
                }
                if (plant.getHealth() <= 0) {
                    plant.setHealth(0);
                    listOfPlantsGame.remove(plant);
                }
            }
        }
        catch (ConcurrentModificationException cme) {
        }
    }

    private static void updateListOfZombiesGame() {
        Map map = UserInterface.getMap();
        ArrayList<Zombie> listOfZombiesGame = map.getListOfZombiesGame();
        try {
            for (Zombie zombie : listOfZombiesGame) {
                if (zombie.getHealth() > 0) {
                    continue;
                }
                if (zombie.getHealth() <= 0) {
                    zombie.setHealth(0);
                    listOfZombiesGame.remove(zombie);
                }
            }
        }
        catch (ConcurrentModificationException cme) {
        }
    }

    public static void drawCenteredText(Graphics2D g, BufferedImage image, int x, int y, String str, Font f) {
        String text = str;
        Font font = f;
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int centerX = (image.getWidth() - textWidth) / 2;

        g.drawString(str, x + centerX, y);
    }

    public static void drawCenteredText(Graphics2D g, BufferedImage image, int x, int y, int offset, String str, Font f) {
        String text = str;
        Font font = f;
        FontMetrics metrics = g.getFontMetrics(font);
        int textWidth = metrics.stringWidth(text);
        int centerX = (image.getWidth() - textWidth) / 2;

        g.drawString(str, x + centerX + offset, y);
    }
}
