package src.mains.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import src.assets.ImageLoader;
import src.mains.KeyHandler;
import src.mains.panels.*;

public class GameLose {
    private static int selectedBox = 0;

    private static BufferedImage[] images = ImageLoader.loadGameLose();

    private static void boxPressed() {
        if (selectedBox == 0) {
            PanelHandler.switchPanel(GamePanel.getInstance(), GamePanel.getInstance());
            GamePanel.gameState = "Playing: Resume";
        }

        if (selectedBox == 1) {
            // SAVE HERE
            PanelHandler.switchPanel(GamePanel.getInstance(), SavePanel.getInstance());
            GamePanel.gameState = "Playing: Save Game";
        }

        if (selectedBox == 2) {
            PanelHandler.switchPanel(GamePanel.getInstance(), InventoryPanel.getInstance());
            GamePanel.gameState = "Inventory";
        }

        if (selectedBox == 3) {
            PanelHandler.switchPanel(GamePanel.getInstance(), HelpPanel.getInstance());
            GamePanel.gameState = "Playing: Help";
        }

        if (selectedBox == 4) {
            PanelHandler.switchPanel(GamePanel.getInstance(), MainMenuPanel.getInstance());
            GamePanel.gameState = "Main Menu";
        }
    }

    public static void update() {
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)) {
            boxPressed();
        }

        int newSelectedBox = selectedBox;
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
            if (selectedBox == 0) {
                newSelectedBox = 4;
            }
            else if (selectedBox == 1 || selectedBox == 2) {
                newSelectedBox = 0;
            }
            else {
                newSelectedBox -= 2;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT) || KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
            if (selectedBox == 0) {
                newSelectedBox = 0;
            }
            else if (selectedBox == 1 || selectedBox == 3) {
                newSelectedBox++;
            }
            else {
                newSelectedBox--;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
            if (selectedBox == 0) {
                newSelectedBox = 2;
            }
            else if (selectedBox == 1 || selectedBox == 2) {
                newSelectedBox += 2;
            }
            else {
                newSelectedBox = 0;
            }
        }

        if (newSelectedBox >= 0 && newSelectedBox < 5){
            selectedBox = newSelectedBox;
        }
    }
    
    public static void draw(Graphics2D g) {
        

    }
}
