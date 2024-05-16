package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

// import assets.AssetsLoader;
import src.assets.AssetsLoader;
import src.mains.KeyHandler;
import src.mains.panels.*;

public class MainMenuPanel extends JPanel {
    public static MainMenuPanel mmp = new MainMenuPanel();

    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = AssetsLoader.loadMainMenu();

    public MainMenuPanel() {
        setPreferredSize(new Dimension(1600, 900));
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
                        GamePanel.gameState = "Main Menu: New Game";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), InventoryPanel.getInstance());
                    }

                    if (selectedBox == 1) {
                        GamePanel.gameState = "Main Menu: Load Game";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        
                    }

                    if (selectedBox == 2) {
                        GamePanel.gameState = "Main Menu: List Plants";
                        PanelHandler.switchPanel(MainMenuPanel.getInstance(), ListPlantsPanel.getInstance());
                    }

                    if (selectedBox == 3) {
                        GamePanel.gameState = "Main Menu: List Zombies";
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

        images[0].paintIcon(this, g2, 0, 0); // background
        images[1].paintIcon(this, g2, 201, 102); // title
        g2.drawImage(gifFrames.get(currentFrame), 417, 392, this);
        // Draw boxes
        g2.drawImage(images[2], 132, 304, null); // start
        g2.drawImage(images[3], 417, 304, null); // load
        g2.drawImage(images[4], 417, 304, null); // list plants
        g2.drawImage(images[5], 417, 304, null); // list zombies
        g2.drawImage(images[6], 132, 392, null); // help
        g2.drawImage(images[7], 417, 392, null); // exit
        
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

