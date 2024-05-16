package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import src.assets.AssetsLoader;
import src.mains.panels.*;

public class HelpPanel extends JPanel {
    public static HelpPanel hp = new HelpPanel();

    private static BufferedImage[] images = AssetsLoader.loadHelpMenu();
    
    private static int page = 0;

    private HelpPanel() {
        setPreferredSize(new Dimension(1600, 900));
        setFocusTraversalKeysEnabled(false);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_RIGHT) {
                    page++;
                    if (page > 3) {
                        page = 0;
                    }
                }

                if (keyCode == KeyEvent.VK_LEFT) {
                    page--;
                    if (page < 0) {
                        page = 3;
                    }
                }

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    if (GamePanel.isCurrentState("Main Menu: Help")) {
                        PanelHandler.switchPanel(HelpPanel.getInstance(), MainMenuPanel.getInstance());
                        GamePanel.gameState = "Main menu";
                    }
                    if (GamePanel.isCurrentState("Inventory: Help")) {
                        PanelHandler.switchPanel(HelpPanel.getInstance(), InventoryPanel.getInstance());
                        GamePanel.gameState = "Inventory";
                    }
                    if (GamePanel.isCurrentState("Game: Help")) {
                        PanelHandler.switchPanel(HelpPanel.getInstance(), GamePanel.getInstance());
                        GamePanel.gameState = "In Game";
                    }
                }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static HelpPanel getInstance() {
        return hp;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(images[page], 0, -15, null);
    }
}
