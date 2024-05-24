package src.entities;

import javax.swing.ImageIcon;

public interface Item {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    int getSpeed();
    int getDirection();
    ImageIcon[] getGif();
}
