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
            GamePanel.gameState = "Game: Restart";
        }

        if (selectedBox == 1) {
            // SAVE HERE
            PanelHandler.switchPanel(GamePanel.getInstance(), SavePanel.getInstance());
            GamePanel.gameState = "Game: Save Game";
        }

        if (selectedBox == 2) {
            PanelHandler.switchPanel(GamePanel.getInstance(), InventoryPanel.getInstance());
            GamePanel.gameState = "Inventory";
        }

        if (selectedBox == 3) {
            PanelHandler.switchPanel(GamePanel.getInstance(), HelpPanel.getInstance());
            GamePanel.gameState = "Game: Help";
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
        g.drawImage(images[0], 0, 0, null);
        g.drawImage(images[1], 0, 0, null);
        g.drawImage(images[2], 0, 0, null);
        g.drawImage(images[3], 0, 0, null);
        g.drawImage(images[4], 0, 0, null);
        g.drawImage(images[5], 0, 0, null);


        if (selectedBox == 0) g.drawImage(images[6], 0, 0, null);
        if (selectedBox == 1) g.drawImage(images[7], 0, 0, null);
        if (selectedBox == 2) g.drawImage(images[8], 0, 0, null);
        if (selectedBox == 3) g.drawImage(images[9], 0, 0, null);
        if (selectedBox == 4) g.drawImage(images[10], 0, 0, null);
    }
}
