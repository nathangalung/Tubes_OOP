package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.assets.AssetsLoader;
import src.mains.KeyHandler;
import src.mains.MouseHandler;

import src.mains.panels.PanelHandler;
import src.mains.panels.InventoryPanel;
import src.mains.panels.ListPlantsPanel;
import src.mains.panels.ListZombiesPanel;
import src.mains.panels.HelpPanel;

public class MainMenuPanel extends JPanel {
    public static MainMenuPanel mmp = new MainMenuPanel();

    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = AssetsLoader.loadImageMainMenu();

    public MainMenuPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setFocusTraversalKeysEnabled(false);
        setLayout(null);

        GamePanel.gameState = "Main Menu";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox == 0) {
                        GamePanel.gameState = "Main Menu: Inventory";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), InventoryPanel.getInstance());
                    }

                    if (selectedBox == 1) {
                        GamePanel.gameState = "Main Menu: Load Game";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        // PanelHandler.switchPanel(MainMenuPanel.getInstance(), LoadPanel.getInstance());
                        
                    }

                    if (selectedBox == 2) {
                        GamePanel.gameState = "Main Menu: Zombies List";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), ListPlantsPanel.getInstance());
                    }

                    if (selectedBox == 3) {
                        GamePanel.gameState = "Main Menu: Zombies List";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), ListZombiesPanel.getInstance());
                    }

                    if (selectedBox == 4) {
                        GamePanel.gameState = "Main Menu: Help";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), HelpPanel.getInstance());
                    }

                    if (selectedBox == 5) {
                        GamePanel.gameState = "Main Menu: Exit Game";
                        System.exit(0);
                    }
                }
                
                int newSelectedBox = selectedBox;

                if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
                    if (selectedBox == 0) {
                        newSelectedBox = 3;
                    }
                    else if (selectedBox == 4) {
                        newSelectedBox = 5;
                    } 
                    else {
                        newSelectedBox--;
                    }
                }

                if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT) || KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
                    if (selectedBox >= 0 && selectedBox < 2) {
                        newSelectedBox = 5;
                    }
                    else if (selectedBox >= 2 && selectedBox < 4) {
                        newSelectedBox = 4;
                    }
                    else if (selectedBox == 4) {
                        newSelectedBox = 3;
                    }
                    else {
                        newSelectedBox = 0;
                    }
                }

                if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
                    if (selectedBox == 3) {
                        newSelectedBox = 0;
                    }
                    else if (selectedBox == 5) {
                        newSelectedBox = 4;
                    }
                    else {
                        newSelectedBox++;
                    }
                }
                
                if (newSelectedBox >= 0 && newSelectedBox <= 5) {
                    selectedBox = newSelectedBox;
                }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static MainMenuPanel getInstance() {
        return mmp;
    }

    public static void init() {
        mmp = new MainMenuPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Background & Title
        g2.drawImage(images[0], 0, 0, null); // background
        g2.drawImage(images[1], 72, 21, null); // title
        
        // Draw Buttons
        g2.drawImage(images[2], 502, 241, null); // start
        g2.drawImage(images[3], 502, 341, null); // load
        g2.drawImage(images[4], 502, 441, null); // plants list
        g2.drawImage(images[5], 502, 541, null); // zombies list
        g2.drawImage(images[6], 1122, 575, null); // help
        g2.drawImage(images[7], 1122, 38, null); // exit
        
        // Draw highlighted boxes
        if (selectedBox == 0) g2.drawImage(images[8], 123, 296, null); // start highlighted
        if (selectedBox == 1) g2.drawImage(images[9], 408, 297, null); // load highlighted
        if (selectedBox == 2) g2.drawImage(images[10], 408, 297, null); // load highlighted
        if (selectedBox == 3) g2.drawImage(images[11], 408, 297, null); // load highlighted
        if (selectedBox == 4) g2.drawImage(images[12], 123, 385, null); // about highlighted
        if (selectedBox == 5) g2.drawImage(images[13], 408, 384, null); // exit highlighted

        g2.dispose();
    }
}

