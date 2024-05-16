package mains.menus;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import assets.AssetsLoader;
import mains.MouseHandler;

import src.main.panels.PanelHandler;
import mains.panels.GamePanel;
import src.assets.ImageLoader;
import src.main.KeyHandler;
import src.main.panels.AboutPanel;
import src.main.panels.MainMenuPanel;
import mains.panels.HelpPanel;
import mains.panels.InventoryPanel;


public class GameWinMenu {
    private static int selectedBox = 0;

    private static BufferedImage[] images = ImageLoader.loadPause();
    private static BufferedImage background = images[0];
    private static BufferedImage nextLevel = images[1];
    private static BufferedImage save = images[2];
    private static BufferedImage inventory = images[3];
    private static BufferedImage main = images[4];
    private static BufferedImage help = images[5];
    private static BufferedImage exit = images[6];
    private static BufferedImage highlightedBox = images[7];

    private static void boxPressed() {
        if (selectedBox == 0) {
            PanelHandler.switchPanel(GamePanel.getInstance(), GamePanel.getInstance());
            GamePanel.gameState = "Next Level";
        }
        if (selectedBox == 1) {
            // SAVE HERE
            PanelHandler.switchPanel(GamePanel.getInstance(), SavePanel.getInstance());
            GamePanel.gameState = "Save Game";
        }
        if (selectedBox == 2) {
            PanelHandler.switchPanel(GamePanel.getInstance(), InventoryPanel.getInstance());
            GamePanel.gameState = "Back to Inventory";
        }
        if (selectedBox == 3) {
            PanelHandler.switchPanel(GamePanel.getInstance(), MainMenuPanel.getInstance());
            GamePanel.gameState = "Back to Main Menu";
        }
        if (selectedBox == 4) {
            PanelHandler.switchPanel(GamePanel.getInstance(), HelpPanel.getInstance());
            GamePanel.gameState = "Help Menu";
        }
        if (selectedBox == 5) {
            System.exit(0);
        }
    }

    public static void update() {
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)){
            boxPressed();
        }

        int newSelectedBox = selectedBox;
        if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
            if (selectedBox == 0 || selectedBox == 1) {
                newSelectedBox += 4;
            }
            else {
                newSelectedBox -= 2;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT)) {
            if (selectedBox == 1 || selectedBox == 3 || selectedBox == 5) {
                newSelectedBox--;
            }
            else {
                newSelectedBox++;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
            if (selectedBox == 4 || selectedBox == 5) {
                newSelectedBox -= 4;
            }
            else {
                newSelectedBox += 2;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
            if (selectedBox == 0 || selectedBox == 2 || selectedBox == 4) {
                newSelectedBox++;
            }
            else {
                newSelectedBox--;
            }
        }
        
        if (newSelectedBox >= 0 && newSelectedBox <= 5) {
            selectedBox = newSelectedBox;
        }
    }

    public static void draw(Graphics2D g){
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, 800, 600);

        g.drawImage(background, 233, 60, null); // Background
        g.drawImage(nextLevel, 269, 167, null); // nextLevel Game button
        g.drawImage(save, 269, 262, null); // Save Game button
        g.drawImage(inventory, 269, 262, null); // Back to Inventory button
        g.drawImage(help, 269, 167, null); // Back to Main Menu button
        g.drawImage(exit, 269, 262, null); // Exit button
        
        if (selectedBox >= 0 && selectedBox <= 5) {
            g.drawImage(highlightedBox, 265, 163, null);
        }
    }
}
