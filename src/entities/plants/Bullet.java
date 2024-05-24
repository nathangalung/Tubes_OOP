// package plants;

// import java.awt.Graphics;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.IOException;

// import javax.imageio.ImageIO;

// import mains.panels.GamePanel;

// public class Bullet {
//     private double x;
//     private double y;
//     BufferedImage image;

//     public Bullet(double x, double y, GamePanel gamePanel){
//         this.x = x;
//         this.y = y;
//         try{
//             File file = new File("../res/PBOO.gif");
//             image = ImageIO.read(file);
//         } catch(IOException e){
//             e.printStackTrace();
//         }
        
//     }

//     public void tick(){
//         x -= 1;
//     }

//     public void render(Graphics g){
//         g.drawImage(image, (int) x, (int) y, null);
//     }
    
// }