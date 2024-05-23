// package maps;

// import java.awt.event.KeyEvent;

// import mains.Consts;
// import mains.KeyHandler;
// import mains.UserInterface;
// import mains.panels.GamePanel;

// public class Cursor {
//     private int x;
//     private int y;
//     private boolean gridMovement = false;

//     public Cursor(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     public int getX() {
//         return x;
//     }

//     public int getY() {
//         return y;
//     }

//     public void setX(int x) {
//         this.x = x;
//     }

//     public void setY(int y) {
//         this.y = y;
//     }

//     public void update() {
//         int newX = x;
//         int newY = y;
//         int speed = 5;
//         int initialSpeed = speed;

//         if (KeyHandler.isKeyPressed(KeyEvent.VK_SHIFT)) {
//             gridMovement = !gridMovement;
//         }

//         if (gridMovement) {
//             newX -= (newX % Consts.TILE_SIZE);
//             newY -= (newY % Consts.TILE_SIZE);

//             if (KeyHandler.isKeyPressed(KeyHandler.KEY_A)) {
//                 newX -= Consts.TILE_SIZE;
//             }
//             if (KeyHandler.isKeyPressed(KeyHandler.KEY_D)) {
//                 newX += Consts.TILE_SIZE;
//             }
//             if (KeyHandler.isKeyPressed(KeyHandler.KEY_W)) {
//                 newY -= Consts.TILE_SIZE;
//             }
//             if (KeyHandler.isKeyPressed(KeyHandler.KEY_S)) {
//                 newY += Consts.TILE_SIZE;
//             }
//         }
            

//         if ((newX >= 0 && newX < GamePanel.WIDTH) && (newY >= 0 && newY < GamePanel.HEIGHT)) {
//             x = newX;
//             y = newY;
//         }
//     }

//     public void enterPressed() {
//         // Implement your logic here for handling enter key press
//     }
// }