package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;

// import assets.AssetsLoader;
import src.assets.AssetsLoader;
import src.mains.KeyHandler;
import src.mains.panels.*;
import src.entities.plants.Plant;

public class InventoryPanel extends JPanel {
    public static InventoryPanel lzp = new InventoryPanel();
    public static Plant[] plants = new Plant[10];
    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = AssetsLoader.loadInventory();

    public InventoryPanel() {
        setPreferredSize(new Dimension(1920, 1080));
        setFocusTraversalKeysEnabled(false);

        GamePanel.gameState = "Inventory";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox == 10) {
                        GamePanel.gameState = "Inventory: Help";
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), HelpPanel.getInstance());
                    }

                    if (selectedBox == 11) {
                        GamePanel.gameState = "Inventory: Save Game";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                    }

                    if (selectedBox == 12) {
                        GamePanel.gameState = "Inventory: Main Menu";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        
                    }
                    if (selectedBox == 13) {
                        GamePanel.gameState = "Inventory: Exit Game";
                        System.exit(0);
                    }
                }
                
                int newSelectedBox = selectedBox;

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
            if (selectedBox >= 0 && selectedBox <= 2) {
                newSelectedBox += 13;
            }
            else if (selectedBox >= 3 && selectedBox <= 4) {
                newSelectedBox += 15;
            }
            else if (selectedBox >= 5 && selectedBox <= 12) {
                newSelectedBox -= 5;
            }
            else if (selectedBox >= 13 && selectedBox <= 15) {
                newSelectedBox -= 3;
            }
            else if (selectedBox >= 16 && selectedBox <= 17) {
                newSelectedBox -= 7;
            }
            else {
                newSelectedBox -= 2;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT)) {
            if (selectedBox == 4 || selectedBox == 9) {
                newSelectedBox -= 4;
            }
            else if (selectedBox == 12) {
                newSelectedBox = 16;
            }
            else if (selectedBox == 15) {
                newSelectedBox = 18;
            }
            else if (selectedBox == 17) {
                newSelectedBox = 10;
            }
            else if (selectedBox == 19) {
                newSelectedBox = 13;
            }
            else {
                newSelectedBox++;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
            if (selectedBox >= 0 && selectedBox <= 7) {
                newSelectedBox += 5;
            }
            else if (selectedBox >= 8 && selectedBox <= 9) {
                newSelectedBox += 10;
            }
            else if (selectedBox >= 10 && selectedBox <= 12) {
                newSelectedBox += 3;
            }
            else if (selectedBox >= 13 && selectedBox <= 15) {
                newSelectedBox -= 13;
            }
            else if (selectedBox >= 16 && selectedBox <= 17) {
                newSelectedBox += 2;
            }
            else {
                newSelectedBox -= 15;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
            if (selectedBox == 0) {
                newSelectedBox = 4;
            }
            else if (selectedBox == 5) {
                newSelectedBox = 9;
            }
            else if (selectedBox == 10) {
                newSelectedBox = 17;
            }
            else if (selectedBox == 13) {
                newSelectedBox = 19;
            }
            else if (selectedBox == 16) {
                newSelectedBox = 12;
            }
            else if (selectedBox == 18) {
                newSelectedBox = 15;
            }
            else {
                newSelectedBox--;
            }
        }
        
        if (newSelectedBox >= 0 && newSelectedBox <= 19) {
            selectedBox = newSelectedBox;
        }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static InventoryPanel getInstance() {
        return lzp;
    }

    public static void init() {
        lzp = new InventoryPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(images[0], 0, 0, null); // background
        g2.drawImage(images[1], 201, 102, null); // title
        
        // Draw boxes
        g2.drawImage(images[2], 132, 304, null); // start
        g2.drawImage(images[3], 417, 304, null); // load
        g2.drawImage(images[4], 417, 304, null); // Inventory
        g2.drawImage(images[5], 417, 304, null); // Inventory
        g2.drawImage(images[6], 132, 392, null); // help
        g2.drawImage(images[7], 417, 392, null); // exit
        
        // Draw highlighted boxes
        if (selectedBox == 0) g2.drawImage(images[8], 123, 296, null); // plant 1 highlighted
        if (selectedBox == 1) g2.drawImage(images[9], 408, 297, null); // plant 2 highlighted
        if (selectedBox == 2) g2.drawImage(images[10], 408, 297, null); // plant 3 highlighted
        if (selectedBox == 3) g2.drawImage(images[11], 408, 297, null); // plant 4 highlighted
        if (selectedBox == 4) g2.drawImage(images[12], 123, 385, null); // plant 5 highlighted
        if (selectedBox == 5) g2.drawImage(images[13], 408, 384, null); // plant 6 highlighted
        if (selectedBox == 6) g2.drawImage(images[13], 408, 384, null); // plant 7 highlighted
        if (selectedBox == 7) g2.drawImage(images[13], 408, 384, null); // plant 8 highlighted
        if (selectedBox == 8) g2.drawImage(images[13], 408, 384, null); // plant 9 highlighted
        if (selectedBox == 9) g2.drawImage(images[13], 408, 384, null); // plant 10 highlighted
        if (selectedBox == 10) g2.drawImage(images[13], 408, 384, null); // help highlighted
        if (selectedBox == 11) g2.drawImage(images[13], 408, 384, null); // main menu highlighted
        if (selectedBox == 12) g2.drawImage(images[13], 408, 384, null); // exit highlighted

        g2.dispose();
    }
}
