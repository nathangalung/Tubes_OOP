package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import src.assets.AssetsLoader;
import src.mains.KeyHandler;
import src.mains.MouseHandler;

import src.mains.panels.PanelHandler;
import src.mains.panels.MainMenuPanel;
import src.mains.panels.InventoryPanel;
import src.mains.panels.GamePanel;

public class HelpPanel extends JPanel {
    public static HelpPanel hp = new HelpPanel();

    private static BufferedImage[] images = AssetsLoader.loadHelpMenu();
    
    private static int page = 0;

    private HelpPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setFocusTraversalKeysEnabled(false);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_RIGHT) {
                    page++;
                    if (page > 4) {
                        page = 0;
                    }
                }

                if (keyCode == KeyEvent.VK_LEFT) {
                    page--;
                    if (page < 0) {
                        page = 4;
                    }
                }

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    if (GamePanel.isCurrentState("Main Menu: Help")) {
                        GamePanel.gameState = "Main Menu";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), MainMenuPanel.getInstance());
                    }
                    if (GamePanel.isCurrentState("Inventory: Help")) {
                        GamePanel.gameState = "Inventory";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), InventoryPanel.getInstance());
                    }
                    if (GamePanel.isCurrentState("Game: Help")) {
                        GamePanel.gameState = "Game";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), GamePanel.getInstance());
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
