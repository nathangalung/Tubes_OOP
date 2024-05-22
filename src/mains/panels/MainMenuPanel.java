package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import src.assets.ImageLoader;
import src.mains.Consts;

// import src.mains.panels.PanelHandler;
// import src.mains.panels.InventoryPanel;
// import src.mains.panels.PlantsListPanel;
// import src.mains.panels.ZombiesListPanel;
// import src.mains.panels.HelpPanel;

public class MainMenuPanel extends JPanel {
    public static MainMenuPanel mmp = new MainMenuPanel();

    private int selectedBox = 0;

    private BufferedImage[] images = ImageLoader.loadMainMenu();

    public MainMenuPanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
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
                        GamePanel.gameState = "Inventory";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), InventoryPanel.getInstance());
                    }

                    // if (selectedBox == 1) {
                    //     GamePanel.gameState = "Main Menu: Load Game";
                    //     // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                    //     PanelHandler.switchPanel(MainMenuPanel.getInstance(), LoadPanel.getInstance());
                        
                    // }

                    if (selectedBox == 2) {
                        GamePanel.gameState = "Plants List";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), PlantsListPanel.getInstance());
                    }

                    if (selectedBox == 3) {
                        GamePanel.gameState = "Zombies List";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), ZombiesListPanel.getInstance());
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

                if (keyCode == KeyEvent.VK_UP) {
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

                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT) {
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

                if (keyCode == KeyEvent.VK_DOWN) {
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
        g2.drawImage(images[2], 502, 241, null); // start game
        g2.drawImage(images[3], 502, 341, null); // load game
        g2.drawImage(images[4], 502, 441, null); // plants list
        g2.drawImage(images[5], 502, 541, null); // zombies list
        g2.drawImage(images[6], 1128, 575, null); // help
        g2.drawImage(images[7], 1128, 35, null); // exit game
        
        // Draw highlighted boxes
        if (selectedBox == 0) g2.drawImage(images[8], 521, 241, null); // start game highlighted
        if (selectedBox == 1) g2.drawImage(images[9], 521, 341, null); // load game highlighted
        if (selectedBox == 2) g2.drawImage(images[10], 521, 441, null); // plants list highlighted
        if (selectedBox == 3) g2.drawImage(images[11], 521, 541, null); // zombies list highlighted
        if (selectedBox == 4) g2.drawImage(images[12], 1121, 568, null); // about highlighted
        if (selectedBox == 5) g2.drawImage(images[13], 1123, 30, null); // exit game highlighted

        g2.dispose();
    }
}

