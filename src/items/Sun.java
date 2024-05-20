package src.items;

import src.entities.Entity;

public class Sun extends Entity implements Item {
    private static int x = (int) (Math.random() * (910 - 160 + 1)) + 160;
    private static int y = 0;
    private static int width = 25;
    private static int height = 25;
    private static int direction = 2;

    public Sun() {
        super(x, y, width, height, direction);
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
