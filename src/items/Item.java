package src.items;

import java.awt.image.BufferedImage;

public interface Item {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int getDirection();
    BufferedImage getImage();
}