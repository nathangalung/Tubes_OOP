package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

// import assets.AssetsLoader;
import src.assets.AssetsLoader;
import src.entities.plants.Plant;

import src.mains.KeyHandler;
import src.mains.MouseHandler;
import src.mains.panels.PanelHandler;
import src.mains.panels.GamePanel;
import src.mains.panels.MainMenuPanel;
import src.mains.panels.HelpPanel;

public class InventoryPanel extends JPanel {
    public static InventoryPanel ip = new InventoryPanel();
    public static int[] plantsInventory = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] plantsDeck = {100, 100, 100, 100, 100, 100};
    private static int[] checkInventory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] checkDeck = {0, 0, 0, 0, 0, 0};

    private int selectedBox = 0; // 0 to 5
    private BufferedImage[] images = AssetsLoader.loadInventoryMenu();

    public InventoryPanel() {
        setPreferredSize(new Dimension(1920, 1080));
        setFocusTraversalKeysEnabled(false);

        GamePanel.gameState = "Inventory";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int sumCheckInventory, sumCheckDeck = 0;
                int check, temp;

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox >= 0 && selectedBox <= 9) {
                        if (checkInventory[selectedBox] == 1) {
                            checkInventory[selectedBox] = 0;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 0 && plantsInventory[selectedBox] != 100) {
                            check = selectedBox;
                            checkInventory[selectedBox] = 1;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] == 100) {
                            // ngeluarin kartu dari deck balikin ke inventory
                            plantsInventory[selectedBox] = plantsDeck[check];
                            plantsDeck[check] = 100;
                            checkDeck[check] = 0;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] != 100) {
                            // nuker antara deck sama inventory
                            temp = plantsInventory[selectedBox];
                            plantsInventory[selectedBox] = plantsDeck[check];
                            plantsDeck[check] = temp;
                            checkDeck[check] = 0;
                        }
                        else if (sumCheckInventory == 1 && sumCheckDeck == 0 && plantsInventory[selectedBox] == 100) {
                            // mindahin kartu dari inventory ada ke inventory kosong
                            plantsInventory[selectedBox] = plantsInventory[check];
                            plantsInventory[check] = 100;
                            checkInventory[check] = 0;
                        }
                        else {
                            // nuker antara inventory sama inventory
                            temp = plantsInventory[selectedBox];
                            plantsInventory[selectedBox] = plantsInventory[check];
                            plantsInventory[check] = temp;
                            checkInventory[check] = 0;
                        }
                    }

                    if (selectedBox >= 10 && selectedBox <= 15) {
                        if (checkDeck[selectedBox - 10] == 1) {
                            checkDeck[selectedBox - 10] = 0;
                        }
                        else if (sumCheckDeck == 0 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] != 100) {
                            check = selectedBox - 10;
                            checkDeck[selectedBox - 10] = 1;
                        }
                        else if (sumCheckDeck == 0 && sumCheckInventory == 1 && plantsDeck[selectedBox - 10] == 100) {
                            // masukin kartu dari inventory ke deck
                            plantsDeck[selectedBox - 10] = plantsInventory[check];
                            plantsInventory[check] = 100;
                            checkInventory[check] = 0;
                        }
                        else if (sumCheckDeck == 0 && sumCheckInventory == 1 && plantsDeck[selectedBox - 10] != 100) {
                            // nuker kartu antara inventory sama deck
                            temp = plantsDeck[selectedBox - 10];
                            plantsDeck[selectedBox - 10] = plantsInventory[check];
                            plantsInventory[check] = temp;
                            checkInventory[check] = 0;
                        }
                        else if (sumCheckDeck == 1 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] == 100) {
                            // pindahin kartu dari deck isi ke deck kosong
                            plantsDeck[selectedBox - 10] = plantsDeck[check];
                            plantsDeck[check] = 100;
                            checkDeck[check] = 0;
                        }
                        else if (sumCheckDeck == 1 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] != 100) {
                            // tuker kartu antar deck yang udh keisi
                            temp = plantsDeck[selectedBox - 10];
                            plantsDeck[selectedBox - 10] = plantsDeck[check];
                            plantsDeck[check] = temp;
                            checkDeck[check] = 0;
                        }
                    }

                    if (selectedBox == 16) {
                        checkInventory = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                        checkDeck = new int[] {100, 100, 100, 100, 100, 100};
                        GamePanel.gameState = "Inventory: Start Game";
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), GamePanel.getInstance());
                    }

                    if (selectedBox == 17) {
                        checkInventory = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                        checkDeck = new int[] {100, 100, 100, 100, 100, 100};
                        GamePanel.gameState = "Inventory: Main Menu";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), MainMenuPanel.getInstance());
                    }

                    if (selectedBox == 18) {
                        GamePanel.gameState = "Inventory: Help";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), HelpPanel.getInstance());
                    }
                    if (selectedBox == 19) {
                        GamePanel.gameState = "Inventory: Exit Game";
                        System.exit(0);
                    }

                    for (int value: checkInventory) {
                        sumCheckInventory += value;
                    }

                    for (int value: checkDeck) {
                        sumCheckDeck += value;
                    }

                    if (sumCheckInventory == 2) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                    }

                    if (sumCheckDeck == 2) {

                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                    }

                    if (sumCheckInventory + sumCheckDeck == 2) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                    }   
                }
                
                int newSelectedBox = selectedBox;

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_UP)) {
            if (selectedBox >= 0 && selectedBox <= 2) {
                newSelectedBox += 13;
            }
            else if (selectedBox >= 3 && selectedBox <= 4) {
                newSelectedBox += 15;
            }
            else if (selectedBox >= 5 && selectedBox <= 12) {
                newSelectedBox -= 5;
            }
            else if (selectedBox >= 13 && selectedBox <= 15) {
                newSelectedBox -= 3;
            }
            else if (selectedBox >= 16 && selectedBox <= 17) {
                newSelectedBox -= 7;
            }
            else {
                newSelectedBox -= 2;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_RIGHT)) {
            if (selectedBox == 4 || selectedBox == 9) {
                newSelectedBox -= 4;
            }
            else if (selectedBox == 12) {
                newSelectedBox = 16;
            }
            else if (selectedBox == 15) {
                newSelectedBox = 18;
            }
            else if (selectedBox == 17) {
                newSelectedBox = 10;
            }
            else if (selectedBox == 19) {
                newSelectedBox = 13;
            }
            else {
                newSelectedBox++;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_DOWN)) {
            if (selectedBox >= 0 && selectedBox <= 7) {
                newSelectedBox += 5;
            }
            else if (selectedBox >= 8 && selectedBox <= 9) {
                newSelectedBox += 10;
            }
            else if (selectedBox >= 10 && selectedBox <= 12) {
                newSelectedBox += 3;
            }
            else if (selectedBox >= 13 && selectedBox <= 15) {
                newSelectedBox -= 13;
            }
            else if (selectedBox >= 16 && selectedBox <= 17) {
                newSelectedBox += 2;
            }
            else {
                newSelectedBox -= 15;
            }
        }

        if (KeyHandler.isKeyPressed(KeyHandler.KEY_LEFT)) {
            if (selectedBox == 0) {
                newSelectedBox = 4;
            }
            else if (selectedBox == 5) {
                newSelectedBox = 9;
            }
            else if (selectedBox == 10) {
                newSelectedBox = 17;
            }
            else if (selectedBox == 13) {
                newSelectedBox = 19;
            }
            else if (selectedBox == 16) {
                newSelectedBox = 12;
            }
            else if (selectedBox == 18) {
                newSelectedBox = 15;
            }
            else {
                newSelectedBox--;
            }
        }
        
        if (newSelectedBox >= 0 && newSelectedBox <= 19) {
            selectedBox = newSelectedBox;
        }
                repaint();
            }
        };
        addKeyListener(keyAdapter);
        setFocusable(true);
    }

    public static InventoryPanel getInstance() {
        return ip;
    }

    public static void init() {
        ip = new InventoryPanel();
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
        g2.drawImage(images[4], 417, 304, null); // Inventory
        g2.drawImage(images[5], 417, 304, null); // Inventory
        g2.drawImage(images[6], 132, 392, null); // help
        g2.drawImage(images[7], 417, 392, null); // exit
        
        // Draw highlighted boxes
        if (selectedBox == 0 || checkInventory[0] == 1) g2.drawImage(images[8], 123, 296, null); // plant 1 highlighted
        if (selectedBox == 1 || checkInventory[1] == 1) g2.drawImage(images[9], 408, 297, null); // plant 2 highlighted
        if (selectedBox == 2 || checkInventory[2] == 1) g2.drawImage(images[10], 408, 297, null); // plant 3 highlighted
        if (selectedBox == 3 || checkInventory[3] == 1) g2.drawImage(images[11], 408, 297, null); // plant 4 highlighted
        if (selectedBox == 4 || checkInventory[4] == 1) g2.drawImage(images[12], 123, 385, null); // plant 5 highlighted
        if (selectedBox == 5 || checkInventory[5] == 1) g2.drawImage(images[13], 408, 384, null); // plant 6 highlighted
        if (selectedBox == 6 || checkInventory[6] == 1) g2.drawImage(images[13], 408, 384, null); // plant 7 highlighted
        if (selectedBox == 7 || checkInventory[7] == 1) g2.drawImage(images[13], 408, 384, null); // plant 8 highlighted
        if (selectedBox == 8 || checkInventory[8] == 1) g2.drawImage(images[13], 408, 384, null); // plant 9 highlighted
        if (selectedBox == 9 || checkInventory[9] == 1) g2.drawImage(images[13], 408, 384, null); // plant 10 highlighted
        if (selectedBox == 10 || checkDeck[0] == 1) g2.drawImage(images[13], 408, 384, null); // help highlighted
        if (selectedBox == 11 || checkDeck[1] == 1) g2.drawImage(images[13], 408, 384, null); // main menu highlighted
        if (selectedBox == 12 || checkDeck[2] == 1) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 13 || checkDeck[3] == 1) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 14 || checkDeck[4] == 1) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 15 || checkDeck[5] == 1) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 16) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 17) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 18) g2.drawImage(images[13], 408, 384, null); // exit highlighted
        if (selectedBox == 19) g2.drawImage(images[13], 408, 384, null); // exit highlighted

        g2.dispose();
    }
}
