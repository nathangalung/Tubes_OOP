package src.entities.zombies;

import java.awt.*;

public class Normal extends Zombie {
    public Normal(int x, int y, int width, int height, float speed, int id , int attack_damage, int attack_speed, String name,boolean is_aquatic) {
        super(x, y, width, height, speed, id, attack_damage, attack_speed, name, is_aquatic);
    }

    public void draw(Graphics g2){
        g2.drawImage(getImg(), getX(), getY(), null);
    }

    @Override
    public void loadImage() {
        // TODO Auto-generated method stub
        super.loadImage();
    }
}
