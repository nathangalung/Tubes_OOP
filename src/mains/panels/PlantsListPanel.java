package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

// import assets.ImageLoader;
import src.assets.ImageLoader;
import src.assets.GifLoader;

import src.mains.Consts;

public class PlantsListPanel extends JPanel {
    public static PlantsListPanel lpp = new PlantsListPanel();

    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = ImageLoader.loadPlantsList();
    private ImageIcon[] gifs = GifLoader.loadPlantsList();

    public PlantsListPanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
        setFocusTraversalKeysEnabled(false);

        // GamePanel.gameState = "Plants List";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox == 10) {
                        GamePanel.gameState = "Plants List: Help";
                        PanelHandler.switchPanel(PlantsListPanel.getInstance(), HelpPanel.getInstance());
                    }

                    if (selectedBox == 11) {
                        GamePanel.gameState = "Main Menu";
                        PanelHandler.switchPanel(PlantsListPanel.getInstance(), MainMenuPanel.getInstance());
                        
                    }
                }
                
                int newSelectedBox = selectedBox;

                if (keyCode == KeyEvent.VK_UP) {
                    if (selectedBox >= 0 && selectedBox < 3) {
                        newSelectedBox = 9;
                    }
                    else if (selectedBox == 10) {
                        newSelectedBox = 11;
                    }
                    else {
                        newSelectedBox -= 3;
                    }
                }

                if (keyCode == KeyEvent.VK_RIGHT) {
                    if (selectedBox == 2) {
                        newSelectedBox = 11;
                    }
                    else if (selectedBox == 5 || selectedBox == 8) {
                        newSelectedBox -= 2;
                    }
                    else if (selectedBox == 10) {
                        newSelectedBox = 9;
                    }
                    else if (selectedBox == 11) {
                        newSelectedBox = 0;
                    }
                    else {
                        newSelectedBox++;
                    }
                }
        
                if (keyCode == KeyEvent.VK_DOWN) {
                    if (selectedBox == 7 || selectedBox == 8) {
                        newSelectedBox = 9;
                    }
                    
                    else if(selectedBox == 9) {
                        newSelectedBox = 0;
                    }
                    else if (selectedBox == 10) {
                        newSelectedBox = 11;
                    }
                    else if (selectedBox == 11) {
                        newSelectedBox = 10;
                    }
                    else {
                        newSelectedBox += 3;
                    }
                }
        
                if (keyCode == KeyEvent.VK_LEFT) {
                    if (selectedBox == 0) {
                        newSelectedBox = 11;
                    }
                    else if (selectedBox == 3 || selectedBox == 6) {
                        newSelectedBox += 2;
                    }
                    else if (selectedBox == 11) {
                        newSelectedBox = 2;
                    }
                    else {
                        newSelectedBox--;
                    }
                }

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    GamePanel.gameState = "Main Menu";
                    PanelHandler.switchPanel(PlantsListPanel.getInstance(), MainMenuPanel.getInstance());
                }
        
        if (newSelectedBox >= 0 && newSelectedBox < 12) {
            selectedBox = newSelectedBox;
        }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static PlantsListPanel getInstance() {
        return lpp;
    }

    public static void init() {
        lpp = new PlantsListPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(images[0], 0, 0, null); // background
        g2.drawImage(images[1], 221, 49, null); // almanac
        g2.drawImage(images[2], 1128, 575, null); // help
        g2.drawImage(images[3], 1075, 35, null); // menu
        
        // Draw Plants
        g2.drawImage(images[6], 284, 184, null); // plant 1
        g2.drawImage(images[7], 399, 184, null); // plant 2
        g2.drawImage(images[8], 514, 184, null); // plant 3
        g2.drawImage(images[9], 284, 300, null); // plant 4
        g2.drawImage(images[10], 399, 300, null); // plant 5
        g2.drawImage(images[11], 514, 300, null); // plant 6
        g2.drawImage(images[12], 284, 400, null); // plant 7
        g2.drawImage(images[13], 399, 400, null); // plant 8
        g2.drawImage(images[14], 514, 400, null); // plant 9
        g2.drawImage(images[15], 284, 500, null); // plant 10
        
        // Draw Highlighted Boxes & Attributes
        if (selectedBox == 0) g2.drawImage(images[16], 279, 178, null);
        if (selectedBox == 1) g2.drawImage(images[17], 394, 178, null);
        if (selectedBox == 2) g2.drawImage(images[18], 509, 178, null);
        if (selectedBox == 3) g2.drawImage(images[19], 279, 294, null);
        if (selectedBox == 4) g2.drawImage(images[20], 394, 294, null);
        if (selectedBox == 5) g2.drawImage(images[21], 509, 294, null);
        if (selectedBox == 6) g2.drawImage(images[22], 279, 394, null);
        if (selectedBox == 7) g2.drawImage(images[23], 394, 394, null);
        if (selectedBox == 8) g2.drawImage(images[24], 509, 394, null);
        if (selectedBox == 9) g2.drawImage(images[25], 279, 494, null);
        if (selectedBox == 10) g2.drawImage(images[4], 1121, 568, null);
        if (selectedBox == 11) g2.drawImage(images[5], 1070, 30, null);

        for (int i = 0; i < 10; i++) {
            if (selectedBox == i) {
                gifs[i].paintIcon(this, g2, 686, 145);
                g2.drawImage(images[i + 26], 679, 139, null);
            }
        }

        g2.dispose();
    }
}

