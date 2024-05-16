package src.items;

import java.awt.image.BufferedImage;
import java.util.List;

public interface Item {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    BufferedImage getIcon();
    BufferedImage[] getImages();
    List<BufferedImage>[] getAnimations();
}