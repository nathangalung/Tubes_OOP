package src.mains.menus;

import java.awt.image.BufferedImage;

import src.assets.ImageLoader;
import src.main.KeyHandler;
import src.main.panels.AboutPanel;
import src.main.panels.GamePanel;
import src.main.panels.MainMenuPanel;
import src.main.panels.PanelHandler;
import src.mains.panels.HelpPanel;

public class GameLose {
    private static int selectedBox = 0;

    private static BufferedImage[] images = ImageLoader.loadGameLose();

    private static void boxPressed() {
        if (selectedBox == 0) {
            PanelHandler.switchPanel(GamePanel.getInstance(), AboutPanel.getInstance());
            GamePanel.gameState = "Playing: Restart";
        }

        if (selectedBox == 1) {
            // SAVE HERE
            PanelHandler.switchPanel(GamePanel.getInstance(), Ga.getInstance());
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
        if(KeyHandler.isKeyPressed(KeyHandler.KEY_ENTER)){
            boxPressed();
        }

        int newSelectedBox = selectedBox;
        if(KeyHandler.isKeyPressed(KeyHandler.KEY_S)){
            newSelectedBox++;
        }
        if(KeyHandler.isKeyPressed(KeyHandler.KEY_W)){
            newSelectedBox--;
        }
        if (newSelectedBox >= 0 && newSelectedBox < 2){
            selectedBox = newSelectedBox;
        }
    }
    
    public static void draw(Graphics2D g){
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, 800, 600);

        g.drawImage(background, 233, 60, null); // Background

        g.drawImage(about, 269, 167, null); // Help button
        g.drawImage(exit, 269, 262, null); // Save and Exit button
        
        if(selectedBox == 0){
            g.drawImage(aboutHighlighted, 265, 163, null);
        }
        if(selectedBox == 1){
            g.drawImage(exitHighlighted, 265, 258, null);
        }
    }
}
