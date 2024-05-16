package mains;

import java.awt.FontMetrics;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ConcurrentModificationException;

import maps.Map;
import plants.Plant;
import zombies.Zombie;
import mains.menus.*;

public class UserInterface {
    public static UserInterface ui = new UserInterface();
    
    // Attributes
    private static Map map;
    private static Plant currentPlant;
    private static Zombie currentZombie;
    
    // User Interface States
    private static boolean viewingMap = true;
    private static boolean viewingInventoryDeck = false;
    private static boolean viewingGameDeck = false;
    private static boolean viewingWave = false;
    private static boolean viewingSun = false;
    private static boolean viewingDig = false;
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
        viewingInventoryDeck = false;
        viewingGameDeck = false;
        viewingWave = false;
        viewingSun = false;
        viewingDig = false;
        viewingFlag = false;
        viewingGamePause = false;
        viewingGameWin = false;
        viewingGameLose = false;

        UserInterface.map = map;
        UserInterface.map.changeIsAddingState();
    }

    // GETTERS
    public static UserInterface getInstance() {
        return ui;
    }

    public static Map getMap() {
        return map;
    }

    public static Plant getPlant() {
        return currentPlant;
    }

    public static Zombie getZombie() {
        return currentZombie;
    }

    public static boolean isViewingMap() {
        return viewingMap;
    }

    public static boolean isViewingInventoryDeck() {
        return viewingInventoryDeck;
    }

    public static boolean isViewingGameDeck() {
        return viewingGameDeck;
    }

    public static boolean isViewingWave() {
        return viewingWave;
    }

    public static boolean isViewingSun() {
        return viewingSun;
    }

    public static boolean isViewingDig() {
        return viewingDig;
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

    // SETTERS
    public static void setCurrentSim(Sim sim) {
        currentSim = sim;
        currentSimInventory = currentSim.getInventory();
    }

    public static void setViewingMap() {
        viewingMap = !viewingMap;
        map.reset();
    }

    public static void setViewingInventoryDeck() {
        viewingInventoryDeck = !viewingInventoryDeck;
    }

    public static void setViewingGameDeck() {
        viewingGameDeck = !viewingGameDeck;
    }

    public static void setViewingWave() {
        viewingWave = !viewingWave;
    }

    public static void setViewingSun() {
        viewingSun = !viewingSun;
    }

    public static void setViewingDig() {
        viewingDig = !viewingDig;
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
    public static void update() {
        updateListOfPlantsGame();
        updateListOfZombiesGame();

        if (viewingInventoryDeck) {
            InventoryDeckMenu.update();
        }

        if (viewingGameDeck) {
            GameDeckMenu.update();
        }

        if (viewingWave) {
            WaveMenu.update();
        }

        if (viewingSun) {
            SunMenu.update();
        }

        if (viewingDig) {
            DigMenu.update();
        }

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
        GameMenu.draw(g);

        TabMenu.draw(g);

        currentSimInventory.draw(g);

        if (viewingInventoryDeck) {
            InventoryDeckMenu.draw(g);
        }

        if (viewingGameDeck) {
            GameDeckMenu.draw(g);
        }

        if (viewingWave) {
            WaveMenu.draw(g);
        }

        if (viewingSun) {
            SunMenu.draw(g);
        }

        if (viewingDig) {
            DigMenu.draw(g);
        }

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
