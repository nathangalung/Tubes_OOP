package zombies;
import zombies.Zombie;

import java.awt.*;

public class Normal extends Zombie {
    public Normal(int x, int y) {
        super( x, y, 1, 1, 1, -1, false,100 , 1, 125);
    }

    // public void draw(Graphics g2){
    //     g2.drawImage(getImg(), getX(), getY(), null);
    // }

    // @Override
    // public void loadImage() {
    //     // TODO Auto-generated method stub
    //     super.loadImage();
    // }
}
