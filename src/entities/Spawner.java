package src.entities;

import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.ImageIcon;

import src.entities.plants.*;
// import src.entities.zombies.Zombie;

public class Spawner {
    private ImageIcon[] image;
    public static int countZombies = 0;
    
    public static Plant createPlant(int index, int x, int y) {
        Plant p = null;
        if (index == 0) p = new Sunflower(x, y);
        else if (index == 1) p = new Peashooter(x, y);
        else if (index == 2) p =  new WallNut(x, y);
        else if (index == 3) p = new SnowPea(x, y);
        else if (index == 4) p = new Squash(x, y);
        else if (index == 5) p = new Lilypad(x, y);
        else if (index == 6) p = new TangleKelp(x, y);
        else if (index == 7) p = new Cactus(x, y);
        else if (index == 8) p = new CherryBomb(x, y);
        else if (index == 9) p = new Jalapeno(x, y);

        return p;
    }
}
