import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

public interface Item {
    float getSpeed();
    int getDirection();
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    BufferedImage getIcon();
    BufferedImage[] getImages();
    List<BufferedImage>[] getAnimations();
}
