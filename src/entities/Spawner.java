package src.entities;

import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.ImageIcon;

import src.entities.zombies.Zombie;

public class Spawner {
    private ImageIcon[] image;
    public static int countZombies = 0;
    
    public Spawner(){

    }

    public void drawZombies(Zombie z, Graphics g){
        super.paintComponent(g);

        g.drawImage(z.getImg(), z.getX(), z.getY(), null);
    }
}
