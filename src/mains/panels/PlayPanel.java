// package src.mains.panels;

// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.Graphics2D;
// import java.awt.event.KeyAdapter;
// import java.awt.event.KeyEvent;
// import java.awt.image.BufferedImage;

// import javax.swing.JPanel;

// import src.assets.AssetsLoader;
// import src.mains.UserInterface;
// import src.mains.Consts;

// public class PlayPanel extends JPanel {
//     public static PlayPanel pp = new PlayPanel();

//     private int selectedBox = 0; // 0 to 5

//     private int[] plantsListPlayDeck = InventoryPanel.plantsDeck;
//     private int[] zombiesListPlayDeck = InventoryPanel.zombiesDeck;

//     private int[] plantsListCooldown = {0, 0, 0, 0, 0, 0};

//     private BufferedImage[] images = AssetsLoader.loadPlay();


//     public PlayPanel() {
//         setPreferredSize(new Dimension(Consts.WIDTH, Consts.HEIGHT));
//         setFocusTraversalKeysEnabled(false);

//         GamePanel.gameState = "Inventory";

//         KeyAdapter keyAdapter = new KeyAdapter() {
//             @Override
//             public void keyPressed(KeyEvent e) {
//                 int keyCode = e.getKeyCode();

//                 // Check if the Enter key was pressed
//                 if (keyCode == KeyEvent.VK_ENTER) {
//                     if (selectedBox >= 0 && selectedBox < 6) {
                        
//                     }
//                     if (selectedBox == 6) {
//                         GamePanel.gameState = "Playing: Pause Game";
//                         UserInterface.isviewingGamePause();
//                     }

//                     if (selectedBox == 7) {
//                         GamePanel.gameState = "Playing: Editing Tile";
//                     }
//                 }
                
//                 int newSelectedBox = selectedBox;

//                 if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
//                     if (selectedBox == 7) {
//                         newSelectedBox = 0;
//                     }
//                     else {
//                         newSelectedBox = 7;
//                     }
//                 }

//                 if (keyCode == KeyEvent.VK_RIGHT) {
//                     if (selectedBox == 7) {
//                         newSelectedBox = 0;
//                     }
//                     else {
//                         newSelectedBox++;
//                     }
//                 }

//                 if (keyCode == KeyEvent.VK_LEFT) {
//                     if (selectedBox == 0) {
//                         newSelectedBox = 7;
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

//     public static PlayPanel getInstance() {
//         return pp;
//     }

//     public static void init() {
//         pp = new PlayPanel();
//     }

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);

//         Graphics2D g2 = (Graphics2D) g;

//         g2.drawImage(images[0], 0, 0, null); // background
//         g2.drawImage(images[1], 0, 0, null); // sun
//         g2.drawImage(images[2], 0, 0, null); // zombie wave
//         g2.drawImage(images[3], 0, 0, null); // zombie head
//         g2.drawImage(images[4], 0, 0, null); // menu
//         g2.drawImage(images[5], 0, 0, null); // shovel

//         for (int i = 0; i < 6; i++) {
//             if (plantsListCooldown[i] == 0) {
//                 g2.drawImage(images[plantsListPlayDeck[i] + 8], 0, 0, null);

//                 if (selectedBox == i) {
//                     g2.drawImage(images[plantsListPlayDeck[i] + 28], 0, 0, null);
                
//                 }
//             }
//             else {
//                 g2.drawImage(images[plantsListPlayDeck[i] + 18], 0, 0, null);

//                 if (selectedBox == i) {
//                     g2.drawImage(images[plantsListPlayDeck[i] + 38], 0, 0, null);
//                 }
//             }
//         }

//         if (selectedBox == 6) {
//             g2.drawImage(images[6], 0, 0, null);
//         }

//         if (selectedBox == 7) {
//             g2.drawImage(images[7], 0, 0, null);
//         }

//         g2.dispose();
//     }
// }