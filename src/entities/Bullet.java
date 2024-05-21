package src.entities;

public class Bullet extends Entity implements Item {
    public Bullet(int x, int y, int width, int height, int speed, int direction, int damage) {
        super(x, y, width, height, speed, direction, damage);
    }

    public int getDamage() {
        return super.getdamage();
    }

    
}
