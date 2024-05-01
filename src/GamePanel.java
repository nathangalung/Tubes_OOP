import javax.swing.JPanel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    private final int originaTiles = 42; //16 x 16
    private final int scale = 3;

    private final int tiles = scale * originaTiles; //48 x 48
    private final int screenCol = 9;
    private final int screenRow = 6;
    private final int screenWidth = tiles * screenCol;
    private final int screenHeight = tiles * screenRow;

    Thread gameThread;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){ 
        while(gameThread != null){
            //do something
            update();
        
            repaint();
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        try{
            File file = new File("../res/peashooter.png");
            BufferedImage image1 = ImageIO.read(file);
            g2.setColor(Color.BLACK);
            g2.fillRect(100, 100, tiles, tiles);
            g2.drawImage(image1, 100, 100,tiles, tiles, null );
        } catch(IOException e){
            e.printStackTrace();
        }
        g2.dispose();
    }

    

}