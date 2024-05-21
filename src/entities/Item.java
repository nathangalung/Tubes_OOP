package src.entities;

import java.awt.image.BufferedImage;

public interface Item {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int getSpeed();
    int getDirection();
    int getAttack();
    BufferedImage getImage();
}
