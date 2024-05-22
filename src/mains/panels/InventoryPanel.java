package src.mains.panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import src.assets.ImageLoader;
// import src.entities.plants.Plant;

import src.mains.Consts;

public class InventoryPanel extends JPanel {
    public static InventoryPanel ip = new InventoryPanel();

    public static int[] plantsTemp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] plantsInventory = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] plantsDeck = {100, 100, 100, 100, 100, 100};
    private static int[] checkInventory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] checkDeck = {0, 0, 0, 0, 0, 0};

    private int selectedBox = 0; // 0 to 20
    
    private BufferedImage[] images = ImageLoader.loadInventory();
    private int[] inventoryX = {70, 230, 390, 550, 710};
    private int[] inventoryY = {110, 220};
    private int[] deckX = {40, 200, 360};
    private int[] deckY = {482, 582};
    private int sumCheckInventory, sumCheckDeck = 0;
    private int check, temp;

    public InventoryPanel() {
        setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
        setFocusTraversalKeysEnabled(false);

        GamePanel.gameState = "Inventory";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Check if the Enter key was pressed
                if (keyCode == KeyEvent.VK_ENTER) {
                    if (selectedBox >= 0 && selectedBox < 10) {
                        if (checkInventory[selectedBox] == 1) {
                            checkInventory[selectedBox] = 0;
                            sumCheckInventory = 0;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 0 && plantsInventory[selectedBox] != 100) {
                            check = selectedBox;
                            checkInventory[selectedBox] = 1;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] == 100) {
                            // ngeluarin kartu dari deck balikin ke inventory
                            checkDeck[check] = 0;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] != 100) {
                            // nuker antara deck sama inventory
                            checkDeck[check] = 0;
                        }
                        else if (sumCheckInventory == 1 && sumCheckDeck == 0 && plantsInventory[selectedBox] == 100) {
                            // mindahin kartu dari inventory ada ke inventory kosong
                            checkInventory[check] = 0;
                        }
                        else {
                            // nuker antara inventory sama inventory
                            temp = plantsInventory[selectedBox];
                            plantsInventory[selectedBox] = plantsInventory[check];
                            plantsInventory[check] = temp;
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                            plantsTemp = plantsInventory;
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
                            checkInventory[check] = 0;
                        }
                        else if (sumCheckDeck == 1 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] == 100) {
                            // pindahin kartu dari deck isi ke deck kosong
                            checkDeck[check] = 0;
                        }
                        else {
                            // tuker kartu antar deck yang udh keisi
                            temp = plantsDeck[selectedBox - 10];
                            plantsDeck[selectedBox - 10] = plantsDeck[check];
                            plantsDeck[check] = temp;
                            checkDeck[check] = 0;
                            sumCheckDeck = 0;
                        }
                    }

                    if (selectedBox == 17) {
                        plantsInventory = plantsTemp;
                        plantsDeck = new int[] {0, 0, 0, 0, 0, 0};
                    }

                    if (selectedBox == 17) {
                        GamePanel.gameState = "Playing";
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), GamePanel.getInstance());
                    }

                    if (selectedBox == 18) {
                        GamePanel.gameState = "Inventory: Help";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), HelpPanel.getInstance());
                    }

                    if (selectedBox == 19) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        GamePanel.gameState = "Main Menu";
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), MainMenuPanel.getInstance());
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
                        sumCheckInventory = 0;
                    }

                    if (sumCheckDeck == 2) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        sumCheckDeck = 0;
                    }

                    if (sumCheckInventory + sumCheckDeck == 2) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        sumCheckInventory = 0;
                        sumCheckDeck = 0;
                    }   
                }

                if (keyCode == KeyEvent.VK_BACK_SPACE) {
                    if (selectedBox >= 10 && selectedBox < 16) {
                        if (plantsDeck[selectedBox - 10] != 100) {
                            for (int x = 0; x < 10; x++) {
                                if (plantsTemp[x] == plantsDeck[selectedBox - 10]) {
                                    plantsInventory[x] = plantsDeck[selectedBox - 10];
                                    break;
                                }
                            }
                            // ngeluarin kartu dari deck balikin ke inventory
                            plantsDeck[selectedBox - 10] = 100;
                            checkDeck[selectedBox - 10] = 0;
                            sumCheckDeck = 0;
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                        }
                    }
                }
                
                int newSelectedBox = selectedBox;

                if (keyCode == KeyEvent.VK_UP) {
                    if (selectedBox >= 0 && selectedBox < 3) {
                        newSelectedBox += 10;
                    }
                    else if (selectedBox >= 3 && selectedBox < 5) {
                        newSelectedBox += 15;
                    }
                    else if (selectedBox >= 5 && selectedBox < 13) {
                        newSelectedBox -= 5;
                    }
                    else if (selectedBox >= 13 && selectedBox < 16) {
                        newSelectedBox -= 3;
                    }
                    else if (selectedBox >= 16 && selectedBox < 18) {
                        newSelectedBox -= 8;
                    }
                    else {
                        newSelectedBox -= 2;
                    }
                }

                if (keyCode == KeyEvent.VK_RIGHT) {
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

                if (keyCode == KeyEvent.VK_DOWN) {
                    if (selectedBox >= 0 && selectedBox < 8) {
                        newSelectedBox += 5;
                    }
                    else if (selectedBox >= 8 && selectedBox < 10) {
                        newSelectedBox += 8;
                    }
                    else if (selectedBox >= 10 && selectedBox < 13) {
                        newSelectedBox += 3;
                    }
                    else if (selectedBox >= 13 && selectedBox < 16) {
                        newSelectedBox -= 13;
                    }
                    else if (selectedBox >= 16 && selectedBox < 18) {
                        newSelectedBox += 2;
                    }
                    else {
                        newSelectedBox -= 15;
                    }
                }

                if (keyCode == KeyEvent.VK_LEFT) {
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
                
                if (newSelectedBox >= 0 && newSelectedBox < 20) {
                    selectedBox = newSelectedBox;
                }

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    GamePanel.gameState = "Main Menu";
                    PanelHandler.switchPanel(InventoryPanel.getInstance(), MainMenuPanel.getInstance());
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
        g2.drawImage(images[1], 40, 52, null);
        g2.drawImage(images[2], 525, 497, null);
        g2.drawImage(images[3], 709, 497, null);
        g2.drawImage(images[4], 525, 597, null);
        g2.drawImage(images[5], 709, 597, null);
        // Draw boxes

        // for (int i = 0; i < 5; i++) {
        //     if (plantsInventory[i] == 100 ) {
        //         if (selectedBox == i) {
        //             g2.drawImage(images[11], inventoryX[i], inventoryY[0], null);
        //         }
        //         else {
        //             g2.drawImage(images[10], inventoryX[i], inventoryY[0], null);
        //         }
        //     }
        //     else {
        //         if (selectedBox == i) {
        //             if (sumCheckDeck + sumCheckInventory == 1) {
        //                 if (checkInventory[i] == 1) g2.drawImage(images[plantsInventory[i] + 42], inventoryX[i]-6, inventoryY[0]-4, null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[i] + 32], inventoryX[i]-6, inventoryY[0]-4, null);
        //             }
        //         }
        //         else {
        //             if (sumCheckDeck + sumCheckInventory > 0) {
        //                 g2.drawImage(images[plantsInventory[i] + 22], inventoryX[i], inventoryY[0], null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[i] + 12], inventoryX[i], inventoryY[0], null);
        //             }
        //         }
        //     }
        // }

        // for (int j = 5; j < 10; j++) {
        //     if (plantsInventory[j] == 100 ) {
        //         if (selectedBox == j) {
        //             g2.drawImage(images[11], inventoryX[j-5], inventoryY[1], null);
        //         }
        //         else {
        //             g2.drawImage(images[10], inventoryX[j-5], inventoryY[1], null);
        //         }
        //     }
        //     else {
        //         if (selectedBox == j) {
        //             if (sumCheckDeck + sumCheckInventory == 1) {
        //                 if (checkInventory[j] == 1) g2.drawImage(images[plantsInventory[j] + 42], inventoryX[j-5]-6, inventoryY[1]-4, null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[j] + 32], inventoryX[j-5]-6, inventoryY[1]-4, null);
        //             }
        //         }
        //         else {
        //             if (sumCheckDeck + sumCheckInventory > 0) {
        //                 g2.drawImage(images[plantsInventory[j] + 22], inventoryX[j-5], inventoryY[1], null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[j] + 12], inventoryX[j-5], inventoryY[1], null);
        //             }
        //         }
        //     }
        // }

        // for (int a = 0; a < 3; a++) {
        //     if (plantsDeck[a] == 100 ) {
        //         if (selectedBox == a + 10) {
        //             g2.drawImage(images[11], deckX[a], deckY[0], null);
        //         }
        //         else {
        //             g2.drawImage(images[10], deckX[a], deckY[0], null);
        //         }
        //     }
        //     else {
        //         if (selectedBox == a + 10) {
        //             if (sumCheckDeck + sumCheckInventory == 1) {
        //                 g2.drawImage(images[plantsInventory[a] + 42], deckX[a]-6, deckY[0]-4, null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[a] + 32], deckX[a]-6, deckY[0]-4, null);
        //             }
        //         }
        //         else {
        //             if (sumCheckDeck + sumCheckInventory > 0) {
        //                 g2.drawImage(images[plantsInventory[a] + 22], deckX[a], deckY[0], null);
        //             }
        //             else {
        //                 g2.drawImage(images[plantsInventory[a] + 12], deckX[a], deckY[0], null);
        //             }
        //         }
        //     }
        // }
        g2.drawImage(images[11], 0, 0, null);

        for (int i = 0; i < 5; i++) {
            if (plantsInventory[i] != 100) {
                g2.drawImage(images[plantsInventory[i] + 12], inventoryX[i], inventoryY[0], null);
            }
            else {
                if (selectedBox == i) {
                    g2.drawImage(images[11], inventoryX[i], inventoryY[0], null);
                }
                else {
                    g2.drawImage(images[10], inventoryX[i], inventoryY[0], null);
                }
            }
        }

        for (int j = 5; j < 10; j++) {
            if (plantsInventory[j] != 100) {
                g2.drawImage(images[plantsInventory[j] + 12], inventoryX[j - 5], inventoryY[1], null);
            }
            else {
                if (selectedBox == j) {
                    g2.drawImage(images[11], inventoryX[j-5], inventoryY[1], null);
                }
                else {
                    g2.drawImage(images[10], inventoryX[j-5], inventoryY[1], null);
                }
            }
        }

        for (int a = 0; a < 3; a++) {
            if (plantsDeck[a] != 100) {
                g2.drawImage(images[plantsDeck[a] + 12], deckX[a], deckY[0], null); // inventory plant 1
            }
            else {
                if ((selectedBox == a + 10)) {
                    g2.drawImage(images[11], deckX[a], deckY[0], null);
                }
                else {
                    g2.drawImage(images[10], deckX[a], deckY[0], null);
                }
            }
        }

        for (int b = 3; b < 6; b++) {
            if (plantsDeck[b] != 100) {
                g2.drawImage(images[plantsDeck[b] + 12], deckX[b - 3], deckY[1], null);
            }
            else {
                if ((selectedBox == b + 10)) {
                    g2.drawImage(images[11], deckX[b-3], deckY[1], null);
                }
                else {
                    g2.drawImage(images[10], deckX[b-3], deckY[1], null);
                }
            }
        }

        
        
        // // Draw highlighted boxes
        
        for (int i = 0; i < 5; i++) {
            if (selectedBox == i && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[plantsInventory[i] + 32], inventoryX[i] - 6, inventoryY[0] - 4, null); // inventory plant 1
            if (checkInventory[i] == 1) g2.drawImage(images[plantsInventory[i] + 22], inventoryX[i], inventoryY[0], null); // inventory plant 1
        }

        for (int j = 5; j < 10; j++) {
            if (selectedBox == j && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[plantsInventory[j] + 32], inventoryX[j-5] - 6, inventoryY[1] - 4, null);
            if (checkInventory[j] == 1) g2.drawImage(images[plantsInventory[j] + 22], inventoryX[j-5], inventoryY[1], null);
        }

        for (int a = 0; a < 3; a++) {
            if ((selectedBox == a + 10) && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[plantsDeck[a] + 32], deckX[a] - 6, deckY[0] - 4, null);
            if (checkDeck[a] == 1) g2.drawImage(images[plantsDeck[a] + 22], deckX[a], deckY[0], null);
        }

        for (int b = 3; b < 6; b++) {
            if ((selectedBox == b + 10) && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[plantsDeck[b] + 32], deckX[b-3] - 6, deckY[1] - 4, null);
            if (checkDeck[b] == 1) g2.drawImage(images[plantsDeck[b] + 22], deckX[b-3], deckY[1], null);
        }

        if (selectedBox == 16) g2.drawImage(images[6], 519, 490, null);
        if (selectedBox == 17) g2.drawImage(images[7], 703, 490, null);
        if (selectedBox == 18) g2.drawImage(images[8], 519, 590, null);
        if (selectedBox == 19) g2.drawImage(images[9], 703, 590, null);

        g2.dispose();
    }
}
