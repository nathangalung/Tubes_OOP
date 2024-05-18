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

import src.main.KeyHandler;
// import src.main.panels.GamePanel;
// import src.main.panels.MainMenuPanel;
// import src.main.panels.HelpPanel;

public class InventoryPanel extends JPanel {
    public static InventoryPanel ip = new InventoryPanel();
    public static int[] plantsInventory = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] plantsDeck = {100, 100, 100, 100, 100, 100};
    private static int[] checkInventory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] checkDeck = {0, 0, 0, 0, 0, 0};

    private int selectedBox = 0; // 0 to 20
    
    private BufferedImage[] images = ImageLoader.loadInventoryMenu();
    private BufferedImage[] cardInventory = ImageLoader.loadCardInventory();
    private BufferedImage[] cardDeck = {null, null, null, null, null, null};
    private int[] cardX = {0, 256, 512, 768, 1024};
    private int[] cardY = {0, 180, 360, 480};
    private int sumCheckInventory, sumCheckDeck = 0;
    private int check, temp;
    private BufferedImage tempCard;

    public InventoryPanel() {
        setPreferredSize(new Dimension(1280, 720));
        setFocusTraversalKeysEnabled(false);

        GamePanel.gameState = "Inventory";

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

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
                            checkDeck[check] = 0;
                            sumCheckDeck = 0;
                        }
                        else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] != 100) {
                            // nuker antara deck sama inventory
                            checkDeck[check] = 0;
                            sumCheckDeck = 0;
                        }
                        else if (sumCheckInventory == 1 && sumCheckDeck == 0 && plantsInventory[selectedBox] == 100) {
                            // mindahin kartu dari inventory ada ke inventory kosong
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                        }
                        else {
                            // nuker antara inventory sama inventory
                            temp = plantsInventory[selectedBox];
                            plantsInventory[selectedBox] = plantsInventory[check];
                            plantsInventory[check] = temp;
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                            tempCard = cardInventory[selectedBox];
                            cardInventory[selectedBox] = cardInventory[check];
                            cardInventory[check] = tempCard;
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
                            sumCheckInventory = 0;
                            cardDeck[selectedBox - 10] = cardInventory[check];
                            cardInventory[check] = null;
                        }
                        else if (sumCheckDeck == 0 && sumCheckInventory == 1 && plantsDeck[selectedBox - 10] != 100) {
                            // nuker kartu antara inventory sama deck
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                        }
                        else if (sumCheckDeck == 1 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] == 100) {
                            // pindahin kartu dari deck isi ke deck kosong
                            checkDeck[check] = 0;
                            sumCheckDeck = 0;
                        }
                        else {
                            // tuker kartu antar deck yang udh keisi
                            temp = plantsDeck[selectedBox - 10];
                            plantsDeck[selectedBox - 10] = plantsDeck[check];
                            plantsDeck[check] = temp;
                            checkDeck[check] = 0;
                            sumCheckDeck = 0;
                            tempCard = cardDeck[selectedBox - 10];
                            cardDeck[selectedBox - 10] = cardDeck[check];
                            cardDeck[check] = tempCard;
                        }
                    }

                    if (selectedBox == 16) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        GamePanel.gameState = "Inventory: Start Game";
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), GamePanel.getInstance());
                    }

                    if (selectedBox == 17) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
                        GamePanel.gameState = "Inventory: Main Menu";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), MainMenuPanel.getInstance());
                    }

                    if (selectedBox == 18) {
                        GamePanel.gameState = "Inventory: Help";
                        // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
                        PanelHandler.switchPanel(InventoryPanel.getInstance(), AboutPanel.getInstance());
                    }
                    if (selectedBox == 19) {
                        checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                        checkDeck = new int[] {0, 0, 0, 0, 0, 0};
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
                    if (selectedBox >= 10 && selectedBox <= 15) {
                        if (plantsDeck[selectedBox - 10] != 100) {
                            // ngeluarin kartu dari deck balikin ke inventory
                            plantsInventory[selectedBox - 10] = plantsDeck[selectedBox - 10];
                            plantsDeck[selectedBox - 10] = 100;
                            checkDeck[selectedBox - 10] = 0;
                            sumCheckDeck = 0;
                            checkInventory[check] = 0;
                            sumCheckInventory = 0;
                            cardInventory[selectedBox - 10] = cardDeck[selectedBox - 10];
                            cardDeck[selectedBox - 10] = null;
                        }
                    }
                }
                
                int newSelectedBox = selectedBox;

                if (keyCode == KeyEvent.VK_UP) {
                    if (selectedBox >= 0 && selectedBox < 3) {
                        newSelectedBox += 12;
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
                        newSelectedBox -= 7;
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

        g2.drawImage(images[0], 1280, 720, null); // background
        
        // Draw boxes

        for (int i = 0; i < 5; i++) {
            if (plantsInventory[i] != 100) {
                g2.drawImage(cardInventory[i], cardX[i], cardY[0], null);
            }
            else {
                g2.drawImage(cardInventory[10], cardX[i], cardY[0], null);
            }
        }

        for (int j = 5; j < 10; j++) {
            if (plantsInventory[j] != 100) {
                g2.drawImage(cardInventory[j], cardX[j - 5], cardY[1], null);
            }
            else {
                g2.drawImage(cardInventory[10], cardX[j - 5], cardY[1], null);
            }
        }

        for (int a = 0; a < 3; a++) {
            if (plantsDeck[a] != 100) {
                g2.drawImage(cardDeck[a], cardX[a], cardY[2], null); // inventory plant 1
            }
            else {
                g2.drawImage(cardInventory[10], cardX[a], cardY[2], null);
            }
        }

        for (int b = 3; b < 6; b++) {
            if (plantsDeck[b] != 100) {
                g2.drawImage(cardDeck[b], cardX[b - 3], cardY[3], null);
            }
            else {
                g2.drawImage(cardInventory[10], cardX[b - 3], cardY[3], null);
            }
        }

        // if (plantsInventory[0] != 100) {
        //     cardInventory[0].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 1
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }
        // if (plantsInventory[1] != 100) {
        //     cardInventory[1].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 2
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }
        // if (plantsInventory[2] != 100) {
        //     cardInventory[2].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 3
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }
        // if (plantsInventory[3] != 100) {
        //     cardInventory[3].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 4
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }
        // if (plantsInventory[4] != 100) {
        //     cardInventory[4].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 5
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsInventory[5] != 100) {
        //     cardInventory[5].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 6
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsInventory[6] != 100) {
        //     cardInventory[6].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 7
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsInventory[7] != 100) {
        //     cardInventory[7].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 8
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsInventory[8] != 100) {
        //     cardInventory[8].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 9
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsInventory[9] != 100) {
        //     cardInventory[9].paintIcon(this, g2, cardX[0], cardY[0]); // inventory plant 10
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[0] != 100) {
        //     cardDeck[0].paintIcon(this, g2, cardX[0], cardY[0]); // deck plant 1
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[1] != 100) {
        //     cardDeck[1].paintIcon(this, g2, cardX[0], cardY[0]); // deck plant 2
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[2] != 100) {
        //     cardDeck[2].paintIcon(this, g2, cardX[0], cardY[0]); // deck plant 3
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[3] != 100) {
        //     cardDeck[5].paintIcon(this, g2, cardX[0], cardY[0]; // deck plant 4
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[4] != 100) {
        //     cardDeck[5].paintIcon(this, g2, cardX[0], cardY[0]); // deck plant 5
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }

        // if (plantsDeck[5] != 100) {
        //     cardDeck[5].paintIcon(this, g2, cardX[0], cardY[0]); // deck plant 6
        // }
        // else {
        //     cardInventory[10].paintIcon(this, g2, cardX[0], cardY[0]);
        // }
        
        // Draw highlighted boxes
        
        for (int i = 0; i < 5; i++) {
            if (selectedBox == i && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[i], cardY[0], null); // inventory plant 1
            if (checkInventory[i] == 1) g2.drawImage(images[4], cardX[i], cardY[0], null); // inventory plant 1
        }

        for (int j = 5; j < 10; j++) {
            if (selectedBox == j && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[j-5], cardY[1], null);
            if (checkInventory[j] == 1) g2.drawImage(images[4], cardX[j-5], cardY[1], null);
        }

        for (int a = 0; a < 3; a++) {
            if (selectedBox == a + 10 && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[a], cardY[2], null);
            if (checkDeck[a] == 1) g2.drawImage(images[4], cardX[a], cardY[2], null);
        }

        for (int b = 3; b < 6; b++) {
            if (selectedBox == b + 10 && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[b-3], cardY[3], null);
            if (checkDeck[b] == 1) g2.drawImage(images[4], cardX[b-3], cardY[3], null);
        }

        for (int m = 16; m < 18; m++) {
            if (selectedBox == m) g2.drawImage(images[3], cardX[m % 13], cardY[2], null);
        }

        for (int n = 18; n < 20; n++) {
            if (selectedBox == n) g2.drawImage(images[3], cardX[n % 15], cardY[3], null);
        }

        // if (selectedBox == 0 || checkInventory[0] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 1 highlighted
        // if (selectedBox == 1 || checkInventory[1] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 2 highlighted
        // if (selectedBox == 2 || checkInventory[2] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 3 highlighted
        // if (selectedBox == 3 || checkInventory[3] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 4 highlighted
        // if (selectedBox == 4 || checkInventory[4] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 5 highlighted
        // if (selectedBox == 5 || checkInventory[5] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 6 highlighted
        // if (selectedBox == 6 || checkInventory[6] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 7 highlighted
        // if (selectedBox == 7 || checkInventory[7] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 8 highlighted
        // if (selectedBox == 8 || checkInventory[8] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 9 highlighted
        // if (selectedBox == 9 || checkInventory[9] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // plant 10 highlighted
        // if (selectedBox == 10 || checkDeck[0] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // help highlighted
        // if (selectedBox == 11 || checkDeck[1] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // main menu highlighted
        // if (selectedBox == 12 || checkDeck[2] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // exit highlighted
        // if (selectedBox == 13 || checkDeck[3] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // exit highlighted
        // if (selectedBox == 14 || checkDeck[4] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // exit highlighted
        // if (selectedBox == 15 || checkDeck[5] == 1) images[13].paintIcon(this, g2, cardX[0], cardY[0]); // exit highlighted

        g2.dispose();
    }
}
