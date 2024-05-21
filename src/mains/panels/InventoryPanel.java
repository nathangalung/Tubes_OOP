// package src.mains.panels;

// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import java.awt.image.BufferedImage;

// import javax.swing.JPanel;

// import src.assets.ImageLoader;
// // import src.entities.plants.Plant;

// import src.main.KeyHandler;
// // import src.main.panels.GamePanel;
// // import src.main.panels.MainMenuPanel;
// // import src.main.panels.HelpPanel;
// import src.main.panels.AboutPanel;
// import src.mains.Consts;

// public class InventoryPanel extends JPanel {
//     public static InventoryPanel ip = new InventoryPanel();

//     public static int[] plantsInventory = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//     public static int[] plantsDeck = {100, 100, 100, 100, 100, 100};
//     private static int[] checkInventory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//     private static int[] checkDeck = {0, 0, 0, 0, 0, 0};

//     private int selectedBox = 0; // 0 to 20
    
//     private BufferedImage[] images = ImageLoader.loadInventoryMenu();
//     private BufferedImage[] cardInventory = ImageLoader.loadCardInventory();
//     private BufferedImage[] cardDeck = {null, null, null, null, null, null};
//     private int[] cardX = {0, 256, 512, 768, 1024};
//     private int[] cardY = {0, 180, 360, 480};
//     private int sumCheckInventory, sumCheckDeck = 0;
//     private int check, temp;
//     private BufferedImage tempCard;

//     public InventoryPanel() {
//         setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
//         setFocusTraversalKeysEnabled(false);

//         GamePanel.gameState = "Inventory";

//         KeyAdapter keyAdapter = new KeyAdapter() {
//             @Override
//             public void keyPressed(KeyEvent e) {
//                 int keyCode = e.getKeyCode();

//                 // Check if the Enter key was pressed
//                 if (keyCode == KeyEvent.VK_ENTER) {
//                     if (selectedBox >= 0 && selectedBox <= 9) {
//                         if (checkInventory[selectedBox] == 1) {
//                             checkInventory[selectedBox] = 0;
//                         }
//                         else if (sumCheckInventory == 0 && sumCheckDeck == 0 && plantsInventory[selectedBox] != 100) {
//                             check = selectedBox;
//                             checkInventory[selectedBox] = 1;
//                         }
//                         else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] == 100) {
//                             // ngeluarin kartu dari deck balikin ke inventory
//                             checkDeck[check] = 0;
//                             sumCheckDeck = 0;
//                         }
//                         else if (sumCheckInventory == 0 && sumCheckDeck == 1 && plantsInventory[selectedBox] != 100) {
//                             // nuker antara deck sama inventory
//                             checkDeck[check] = 0;
//                             sumCheckDeck = 0;
//                         }
//                         else if (sumCheckInventory == 1 && sumCheckDeck == 0 && plantsInventory[selectedBox] == 100) {
//                             // mindahin kartu dari inventory ada ke inventory kosong
//                             checkInventory[check] = 0;
//                             sumCheckInventory = 0;
//                         }
//                         else {
//                             // nuker antara inventory sama inventory
//                             temp = plantsInventory[selectedBox];
//                             plantsInventory[selectedBox] = plantsInventory[check];
//                             plantsInventory[check] = temp;
//                             checkInventory[check] = 0;
//                             sumCheckInventory = 0;
//                             tempCard = cardInventory[selectedBox];
//                             cardInventory[selectedBox] = cardInventory[check];
//                             cardInventory[check] = tempCard;
//                         }
//                     }

//                     if (selectedBox >= 10 && selectedBox <= 15) {
//                         if (checkDeck[selectedBox - 10] == 1) {
//                             checkDeck[selectedBox - 10] = 0;
//                         }
//                         else if (sumCheckDeck == 0 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] != 100) {
//                             check = selectedBox - 10;
//                             checkDeck[selectedBox - 10] = 1;
//                         }
//                         else if (sumCheckDeck == 0 && sumCheckInventory == 1 && plantsDeck[selectedBox - 10] == 100) {
//                             // masukin kartu dari inventory ke deck
//                             plantsDeck[selectedBox - 10] = plantsInventory[check];
//                             plantsInventory[check] = 100;
//                             checkInventory[check] = 0;
//                             sumCheckInventory = 0;
//                             cardDeck[selectedBox - 10] = cardInventory[check];
//                             cardInventory[check] = null;
//                         }
//                         else if (sumCheckDeck == 0 && sumCheckInventory == 1 && plantsDeck[selectedBox - 10] != 100) {
//                             // nuker kartu antara inventory sama deck
//                             checkInventory[check] = 0;
//                             sumCheckInventory = 0;
//                         }
//                         else if (sumCheckDeck == 1 && sumCheckInventory == 0 && plantsDeck[selectedBox - 10] == 100) {
//                             // pindahin kartu dari deck isi ke deck kosong
//                             checkDeck[check] = 0;
//                             sumCheckDeck = 0;
//                         }
//                         else {
//                             // tuker kartu antar deck yang udh keisi
//                             temp = plantsDeck[selectedBox - 10];
//                             plantsDeck[selectedBox - 10] = plantsDeck[check];
//                             plantsDeck[check] = temp;
//                             checkDeck[check] = 0;
//                             sumCheckDeck = 0;
//                             tempCard = cardDeck[selectedBox - 10];
//                             cardDeck[selectedBox - 10] = cardDeck[check];
//                             cardDeck[check] = tempCard;
//                         }
//                     }

//                     if (selectedBox == 16) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         GamePanel.gameState = "Inventory: Start Game";
//                         PanelHandler.switchPanel(InventoryPanel.getInstance(), GamePanel.getInstance());
//                     }

//                     if (selectedBox == 17) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         GamePanel.gameState = "Inventory: Main Menu";
//                         // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
//                         PanelHandler.switchPanel(InventoryPanel.getInstance(), MainMenuPanel.getInstance());
//                     }

//                     if (selectedBox == 18) {
//                         GamePanel.gameState = "Inventory: Help";
//                         // NOTHING SINCE LOAD HASN'T BEEN IMPLEMENTED
//                         PanelHandler.switchPanel(InventoryPanel.getInstance(), AboutPanel.getInstance());
//                     }
//                     if (selectedBox == 19) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         GamePanel.gameState = "Inventory: Exit Game";
//                         System.exit(0);
//                     }

//                     for (int value: checkInventory) {
//                         sumCheckInventory += value;
//                     }

//                     for (int value: checkDeck) {
//                         sumCheckDeck += value;
//                     }

//                     if (sumCheckInventory == 2) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         sumCheckInventory = 0;
//                     }

//                     if (sumCheckDeck == 2) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         sumCheckDeck = 0;
//                     }

//                     if (sumCheckInventory + sumCheckDeck == 2) {
//                         checkInventory = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//                         checkDeck = new int[] {0, 0, 0, 0, 0, 0};
//                         sumCheckInventory = 0;
//                         sumCheckDeck = 0;
//                     }   
//                 }

//                 if (keyCode == KeyEvent.VK_BACK_SPACE) {
//                     if (selectedBox >= 10 && selectedBox <= 15) {
//                         if (plantsDeck[selectedBox - 10] != 100) {
//                             // ngeluarin kartu dari deck balikin ke inventory
//                             plantsInventory[selectedBox - 10] = plantsDeck[selectedBox - 10];
//                             plantsDeck[selectedBox - 10] = 100;
//                             checkDeck[selectedBox - 10] = 0;
//                             sumCheckDeck = 0;
//                             checkInventory[check] = 0;
//                             sumCheckInventory = 0;
//                             cardInventory[selectedBox - 10] = cardDeck[selectedBox - 10];
//                             cardDeck[selectedBox - 10] = null;
//                         }
//                     }
//                 }
                
//                 int newSelectedBox = selectedBox;

//                 if (keyCode == KeyEvent.VK_UP) {
//                     if (selectedBox >= 0 && selectedBox < 3) {
//                         newSelectedBox += 12;
//                     }
//                     else if (selectedBox >= 3 && selectedBox < 5) {
//                         newSelectedBox += 15;
//                     }
//                     else if (selectedBox >= 5 && selectedBox < 13) {
//                         newSelectedBox -= 5;
//                     }
//                     else if (selectedBox >= 13 && selectedBox < 16) {
//                         newSelectedBox -= 3;
//                     }
//                     else if (selectedBox >= 16 && selectedBox < 18) {
//                         newSelectedBox -= 7;
//                     }
//                     else {
//                         newSelectedBox -= 2;
//                     }
//                 }

//                 if (keyCode == KeyEvent.VK_RIGHT) {
//                     if (selectedBox == 4 || selectedBox == 9) {
//                         newSelectedBox -= 4;
//                     }
//                     else if (selectedBox == 12) {
//                         newSelectedBox = 16;
//                     }
//                     else if (selectedBox == 15) {
//                         newSelectedBox = 18;
//                     }
//                     else if (selectedBox == 17) {
//                         newSelectedBox = 10;
//                     }
//                     else if (selectedBox == 19) {
//                         newSelectedBox = 13;
//                     }
//                     else {
//                         newSelectedBox++;
//                     }
//                 }

//                 if (keyCode == KeyEvent.VK_DOWN) {
//                     if (selectedBox >= 0 && selectedBox <= 7) {
//                         newSelectedBox += 5;
//                     }
//                     else if (selectedBox >= 8 && selectedBox <= 9) {
//                         newSelectedBox += 10;
//                     }
//                     else if (selectedBox >= 10 && selectedBox <= 12) {
//                         newSelectedBox += 3;
//                     }
//                     else if (selectedBox >= 13 && selectedBox <= 15) {
//                         newSelectedBox -= 13;
//                     }
//                     else if (selectedBox >= 16 && selectedBox <= 17) {
//                         newSelectedBox += 2;
//                     }
//                     else {
//                         newSelectedBox -= 15;
//                     }
//                 }

//                 if (keyCode == KeyEvent.VK_LEFT) {
//                     if (selectedBox == 0) {
//                         newSelectedBox = 4;
//                     }
//                     else if (selectedBox == 5) {
//                         newSelectedBox = 9;
//                     }
//                     else if (selectedBox == 10) {
//                         newSelectedBox = 17;
//                     }
//                     else if (selectedBox == 13) {
//                         newSelectedBox = 19;
//                     }
//                     else if (selectedBox == 16) {
//                         newSelectedBox = 12;
//                     }
//                     else if (selectedBox == 18) {
//                         newSelectedBox = 15;
//                     }
//                     else {
//                         newSelectedBox--;
//                     }
//                 }
                
//                 if (newSelectedBox >= 0 && newSelectedBox <= 19) {
//                     selectedBox = newSelectedBox;
//                 }
//                 repaint();
//             }
//         };
//         addKeyListener(keyAdapter);
//         setFocusable(true);
//     }

//     public static InventoryPanel getInstance() {
//         return ip;
//     }

//     public static void init() {
//         ip = new InventoryPanel();
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);

//         Graphics2D g2 = (Graphics2D) g;

//         g2.drawImage(images[0], 1280, 720, null); // background
        
//         // Draw boxes

//         for (int i = 0; i < 5; i++) {
//             if (plantsInventory[i] != 100) {
//                 g2.drawImage(cardInventory[i], cardX[i], cardY[0], null);
//             }
//             else {
//                 g2.drawImage(cardInventory[10], cardX[i], cardY[0], null);
//             }
//         }

//         for (int j = 5; j < 10; j++) {
//             if (plantsInventory[j] != 100) {
//                 g2.drawImage(cardInventory[j], cardX[j - 5], cardY[1], null);
//             }
//             else {
//                 g2.drawImage(cardInventory[10], cardX[j - 5], cardY[1], null);
//             }
//         }

//         for (int a = 0; a < 3; a++) {
//             if (plantsDeck[a] != 100) {
//                 g2.drawImage(cardDeck[a], cardX[a], cardY[2], null); // inventory plant 1
//             }
//             else {
//                 g2.drawImage(cardInventory[10], cardX[a], cardY[2], null);
//             }
//         }

//         for (int b = 3; b < 6; b++) {
//             if (plantsDeck[b] != 100) {
//                 g2.drawImage(cardDeck[b], cardX[b - 3], cardY[3], null);
//             }
//             else {
//                 g2.drawImage(cardInventory[10], cardX[b - 3], cardY[3], null);
//             }
//         }

        
        
//         // Draw highlighted boxes
        
//         for (int i = 0; i < 5; i++) {
//             if (selectedBox == i && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[i], cardY[0], null); // inventory plant 1
//             if (checkInventory[i] == 1) g2.drawImage(images[4], cardX[i], cardY[0], null); // inventory plant 1
//         }

//         for (int j = 5; j < 10; j++) {
//             if (selectedBox == j && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[j-5], cardY[1], null);
//             if (checkInventory[j] == 1) g2.drawImage(images[4], cardX[j-5], cardY[1], null);
//         }

//         for (int a = 0; a < 3; a++) {
//             if (selectedBox == a + 10 && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[a], cardY[2], null);
//             if (checkDeck[a] == 1) g2.drawImage(images[4], cardX[a], cardY[2], null);
//         }

//         for (int b = 3; b < 6; b++) {
//             if (selectedBox == b + 10 && sumCheckInventory + sumCheckDeck < 2) g2.drawImage(images[3], cardX[b-3], cardY[3], null);
//             if (checkDeck[b] == 1) g2.drawImage(images[4], cardX[b-3], cardY[3], null);
//         }

//         for (int m = 16; m < 18; m++) {
//             if (selectedBox == m) g2.drawImage(images[3], cardX[m % 13], cardY[2], null);
//         }

//         for (int n = 18; n < 20; n++) {
//             if (selectedBox == n) g2.drawImage(images[3], cardX[n % 15], cardY[3], null);
//         }

//         g2.dispose();
//     }
// }
