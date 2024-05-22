package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

// import assets.ImageLoader;
import src.assets.ImageLoader;
import src.assets.GifLoader;
import src.mains.Consts;

public class ZombiesListPanel extends JPanel {
    public static ZombiesListPanel lzp = new ZombiesListPanel();

    private int selectedBox = 0; // 0 to 5

    private BufferedImage[] images = ImageLoader.loadZombiesList();
    private ImageIcon[] gifs = GifLoader.loadZombiesList();

    private JLabel gifLabel;

    public ZombiesListPanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
        setFocusTraversalKeysEnabled(false);

        // GamePanel.gameState = "Zombies List";

        

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox == 10) {
                        GamePanel.gameState = "Zombies List: Help";
                        PanelHandler.switchPanel(ZombiesListPanel.getInstance(), HelpPanel.getInstance());
                    }

                    if (selectedBox == 11) {
                        GamePanel.gameState = "Main Menu";
                        PanelHandler.switchPanel(ZombiesListPanel.getInstance(), MainMenuPanel.getInstance());
                        
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
                    else if (selectedBox == 11) {
                        newSelectedBox = 10;
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
                    else if (selectedBox == 10) {
                        newSelectedBox = 9;
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
                    PanelHandler.switchPanel(ZombiesListPanel.getInstance(), MainMenuPanel.getInstance());
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

    public static ZombiesListPanel getInstance() {
        return lzp;
    }

    public static void init() {
        lzp = new ZombiesListPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        gifLabel = new JLabel();
        this.add(gifLabel);

        g2.drawImage(images[0], 0, 0, null); // background
        g2.drawImage(images[1], 221, 49, null); // almanac
        g2.drawImage(images[2], 1128, 575, null); // help
        g2.drawImage(images[3], 1075, 35, null); // menu
        
        // Draw Zombies
        g2.drawImage(images[6], 295, 170, null); // zombie 1
        g2.drawImage(images[7], 439, 181, null); // zombie 2
        g2.drawImage(images[8], 575, 181, null); // zombie 3
        g2.drawImage(images[9], 303, 281, null); // zombie 4
        g2.drawImage(images[10], 439, 281, null); // zombie 5
        g2.drawImage(images[11], 575, 281, null); // zombie 6
        g2.drawImage(images[12], 303, 383, null); // zombie 7
        g2.drawImage(images[13], 439, 383, null); // zombie 8
        g2.drawImage(images[14], 575, 383, null); // zombie 9
        g2.drawImage(images[15], 303, 487, null); // zombie 10
        
        // Draw Highlighted Boxes & Attributes
        if (selectedBox == 0) g2.drawImage(images[16], 295, 170, null);
        if (selectedBox == 1) g2.drawImage(images[17], 431, 174, null);
        if (selectedBox == 2) g2.drawImage(images[18], 567, 174, null);
        if (selectedBox == 3) g2.drawImage(images[19], 295, 274, null);
        if (selectedBox == 4) g2.drawImage(images[20], 431, 274, null);
        if (selectedBox == 5) g2.drawImage(images[21], 567, 274, null);
        if (selectedBox == 6) g2.drawImage(images[22], 295, 376, null);
        if (selectedBox == 7) g2.drawImage(images[23], 431, 376, null);
        if (selectedBox == 8) g2.drawImage(images[24], 567, 376, null);
        if (selectedBox == 9) g2.drawImage(images[25], 295, 480, null);
        if (selectedBox == 10) g2.drawImage(images[4], 1121, 568, null);
        if (selectedBox == 11) g2.drawImage(images[5], 1070, 30, null);

        for (int i = 0; i < 10; i ++) {
            if (selectedBox == i) {
                gifs[i].paintIcon(this, g2, 775, 190);
                g2.drawImage(images[i + 26], 722, 157, null);
            }
        }

        g2.dispose();
    }
}

