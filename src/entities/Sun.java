package src.entities;

import java.awt.image.BufferedImage;

public class Sun extends Entity implements Item {
    private static int x = (int) (Math.random() * (910 - 160 + 1)) + 160;
    private static int y = 0;
    private static int width = 25;
    private static int height = 25;
    private static int speed = 5;
    private static int direction = 2;
    private static int attack = 0;

    public Sun() {
        super(x, 0, 1, 1, speed, direction);
    }

    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDirection() {
        return direction;
    }

    public BufferedImage getImage() {
        return null;
    }
}
