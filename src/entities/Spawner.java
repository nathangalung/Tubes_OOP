package src.entities;

import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.ImageIcon;

import src.entities.plants.*;
import src.entities.zombies.*;

public class Spawner {
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

    public static Zombie createZombie(int index, int x, int y) {
        Zombie z = null;
        if (index == 0) z = new Normal(x, y);
        else if (index == 1) z = new Conehead(x, y);
        else if (index == 2) z = new PoleVaulting(x, y);
        else if (index == 3) z = new Buckethead(x, y);
        else if (index == 4) z = new DuckyTube(x, y);
        else if (index == 5) z = new DolphinRider(x, y);
        else if (index == 6) z = new JackInTheBox(x, y);
        else if (index == 7) z = new ScreenDoor(x, y);
        else if (index == 8) z = new Football(x, y);
        else if (index == 9) z = new Newspaper(x, y);

        return z;
    }
}
