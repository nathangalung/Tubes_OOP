package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import javax.swing.JPanel;

// import assets.ImageLoader;
import src.assets.ImageLoader;

import src.mains.panels.PanelHandler;
import src.mains.panels.MainMenuPanel;
import src.mains.panels.HelpPanel;

public class ListZombiesPanel extends JPanel {
    public static ListZombiesPanel lzp = new ListZombiesPanel();

    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = ImageLoader.loadMainMenu();

    public ListZombiesPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setFocusTraversalKeysEnabled(false);

        GamePanel.gameState = "List Zombies";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox == 10) {
                        GamePanel.gameState = "List Zombies: Main Menu";
                        PanelHandler.switchPanel(ListZombiesPanel.getInstance(), MainMenuPanel.getInstance());
                    }

                    if (selectedBox == 11) {
                        GamePanel.gameState = "List Zombies: Help";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(ListZombiesPanel.getInstance(), HelpPanel.getInstance());
                        
                    }
                    if (selectedBox == 12) {
                        GamePanel.gameState = "List Zombies: Exit Game";
                        System.exit(0);
                    }
                }
                
                int newSelectedBox = selectedBox;

        if (keyCode == KeyEvent.VK_UP) {
            if (selectedBox >= 0 && selectedBox < 2) {
                newSelectedBox = 8;
            }
            else if (selectedBox >= 2 && selectedBox < 4) {
                newSelectedBox = 9;
            }
            else if (selectedBox >= 4 && selectedBox < 10) {
                newSelectedBox -= 4;
            }
            else if (selectedBox == 10) {
                newSelectedBox += 2;
            }
            else {
                newSelectedBox--;
            }
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            if (selectedBox == 3 || selectedBox == 7) {
                newSelectedBox -= 3;
            }
            else if (selectedBox == 9) {
                newSelectedBox = 8;
            }
            else if (selectedBox >= 10 && selectedBox < 13) {
                newSelectedBox = 8;
            }
            else {
                newSelectedBox++;
            }
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            if (selectedBox >= 0 && selectedBox < 4) {
                newSelectedBox += 4;
            }
            else if (selectedBox >= 4 && selectedBox < 6) {
                newSelectedBox = 8;
            }
            else if (selectedBox >= 6 && selectedBox < 8) {
                newSelectedBox = 9;
            }
            else if (selectedBox == 12) {
                newSelectedBox = 10;
            }
            else {
                newSelectedBox++;
            }
        }

        if (keyCode == KeyEvent.VK_UP) {
            if (selectedBox == 0 || selectedBox == 4) {
                newSelectedBox += 3;
            }
            else if (selectedBox == 8) {
                newSelectedBox = 9;
            }
            else if (selectedBox >= 10 && selectedBox < 13) {
                newSelectedBox = 9;
            }
            else {
                newSelectedBox--;
            }
        }
        
        if (newSelectedBox >= 0 && newSelectedBox <= 12) {
            selectedBox = newSelectedBox;
        }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static ListZombiesPanel getInstance() {
        return lzp;
    }

    public static void init() {
        lzp = new ListZombiesPanel();
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
        g2.drawImage(images[4], 417, 304, null); // list Zombies
        g2.drawImage(images[5], 417, 304, null); // list Zombies
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

