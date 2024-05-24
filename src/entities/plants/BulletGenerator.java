// package plants;

// import java.awt.Graphics;
// import java.util.ArrayList;
// import java.util.List;

// import mains.panels.GamePanel;

// public class BulletGenerator {
//     private List<Bullet> bullets = new ArrayList<Bullet>();

//     Bullet tempBullet;
//     GamePanel gamePanel;

//     public BulletGenerator(GamePanel gamePanel){
//         this.gamePanel = gamePanel;
//         addBullet(new Bullet(100, 100, gamePanel));


//     }

//     public void tick(){
//         for(int i = 0; i < bullets.size() ; i++){
//             tempBullet = bullets.get(i);
//             tempBullet.tick();
//         }
//     }

//     public void render(Graphics g){
//         for(int i = 0; i < bullets.size() ; i++){
//             tempBullet = bullets.get(i);
//             tempBullet.render(g);
//         }        
//     }

//     public void addBullet(Bullet b){
//         bullets.add(b);
//     }

//     public void removeBullet(Bullet b){
//         bullets.remove(b);
//     }
    
// }