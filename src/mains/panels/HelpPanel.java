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

public class HelpPanel extends JPanel {
    public static HelpPanel hp = new HelpPanel();

    private static BufferedImage[] images = ImageLoader.loadHelp();
    
    private static int page = 0;

    private HelpPanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
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
                        GamePanel.gameState = "Main Menu";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), MainMenuPanel.getInstance());
                    }

                    if (GamePanel.isCurrentState("Inventory: Help")) {
                        GamePanel.gameState = "Inventory";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), InventoryPanel.getInstance());
                    }

                    if (GamePanel.isCurrentState("Plants List: Help")) {
                        GamePanel.gameState = "Plants List";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), PlantsListPanel.getInstance());
                    }

                    if (GamePanel.isCurrentState("Zombies List: Help")) {
                        GamePanel.gameState = "Zombies List";
                        PanelHandler.switchPanel(HelpPanel.getInstance(), ZombiesListPanel.getInstance());
                    }

                    if (GamePanel.isCurrentState("Game: Help")) {
                        GamePanel.gameState = "Game: Pause";
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
        g2.drawImage(images[0], 0, 0, null);
        g2.drawImage(images[page + 1], 184, 100, null);
    }
}
