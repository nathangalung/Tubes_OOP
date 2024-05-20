package src.mains.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import src.entities.plants.Plant;
import src.entities.zombies.Zombie;
import src.mains.Consts;
import src.mains.KeyHandler;
import src.mains.UserInterface;
import src.mains.times.GameTime;
import src.maps.Map;

public class GamePanel extends JPanel implements Runnable {
    private static GamePanel gp = new GamePanel();

    public static String gameState;
    public static GameTime time;

    public static Map map;

    private GamePanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
        setBackground(new Color(110, 196, 213));
        setDoubleBuffered(true);
        // Create a KeyAdapter and add it as a key listener to the panel
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyHandler.keyPressed(e.getKeyCode());
                
                KeyHandler.keyBinds();

                if (UserInterface.isUpgradingHouse()) {
                    UpgradeHouseMenu.update(e);
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                KeyHandler.keyReleased(e.getKeyCode());
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        new Thread(this).start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        int fps = 0;
        double time = 0;
        final double TARGET_FPS = 60.0;
        final double OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        double accumulator = 0.0;
        while (true) {
            long now = System.nanoTime();
            double deltaTime = (now - lastTime) / 1000000000.0;
            lastTime = now;
            accumulator += deltaTime;
            while (accumulator >= OPTIMAL_TIME / 1000000000.0) {
                update();
                accumulator -= OPTIMAL_TIME / 1000000000.0;
            }
            revalidate();
            repaint();
            fps++;
            time += deltaTime;
            if (time > 1.0) {
                System.out.println("Game Window - FPS: " + fps);
                fps = 0;
                time = 0;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // GETTERS
    public static GamePanel getInstance() {
        return gp;
    }
    
    public static boolean isCurrentState(String state) {
        return gameState.equals(state); 
    }

    private void update() {
        try {
            if (isCurrentState("Main Menu")) return;

            if (isCurrentState("Main Menu: Help") || isCurrentState("Game: Help") || isCurrentState("Game: Pause")) return;
    
            if (isCurrentState("Main Menu: Inventory") || isCurrentState("Inventory")) return;

            if (UserInterface.isViewingMap()) {
                map.update();
            }
            else {
                Plant currentPlant = UserInterface.getCurrentPlant();
                Zombie currentZombie = UserInterface.getCurrentZombie();
                Map currentMap = currentZombie.getCurrentMap();
                
                currentPlant.update();
                currentZombie.update();
                currentMap.update();
                UserInterface.update();
            }
        }
        catch (NullPointerException e) {}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        try {
            if (isCurrentState("Main Menu")) return;

            if (isCurrentState("Main Menu: Help") || isCurrentState("Playing: About")) return;
    
            if (isCurrentState("Main Menu: Inventory") || isCurrentState("Inventory")) return;
    
            if (UserInterface.isViewingMap()) {
                WorldMenu.draw(g2);
            }
            else {
                Plant currentPlant = UserInterface.getCurrentPlant();
                Zombie currentZombie = UserInterface.getCurrentZombie();
                Map currentMap = currentMap.getCurrentMap();

                currentMap.draw(g2);
                UserInterface.draw(g2);
            }
        }
        catch (NullPointerException e) {}
        
        // To free resources
        g2.dispose();
    }
}