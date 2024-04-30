import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable {
    private final int originaTiles = 16; //16 x 16
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

    public void run(){

    }
}
