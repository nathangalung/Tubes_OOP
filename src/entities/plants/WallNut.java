package plants;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

import src.assets.AssetsLoader;
import src.entities.zombies.Zombie;
import src.mains.UserInterface;
import src.mains.Consts;
import src.maps.Map;

public class WallNut extends Plant {
    // Attributes
    // private int *skill_tambahan_kalo_aada*;

    // Images & Gifs of the Wall Nut
    private BufferedImage icon;
    private BufferedImage[] images;
    private List<BufferedImage>[] animations;

    public WallNut() {
        super(0, 0, 1, 1, 2, "Wall-nut", 50, 1000, 0, 0, 0 , 20);

        this.images = AssetsLoader.loadPlantImage();
        this.animations = AssetsLoader.loadPlantAnimations();
        updateBounds();

        switch (door.getImageIndex()) {
            case 0:
                setImageIndex(2);
                setX(door.getX());
                setPlayAreaY(5);
                getBounds().setBounds(getX(), getY() + (Consts.SCALED_TILE - 24), Consts.SCALED_TILE, 24);
                break;
            case 1:
                setImageIndex(3);
                setPlayAreaX(0);
                setY(door.getY());
                getBounds().setBounds(getX(), getY(), 24, Consts.SCALED_TILE);
                break;
            case 2:
                setImageIndex(0);
                setX(door.getX());
                setPlayAreaY(0);
                getBounds().setBounds(getX(), getY(), Consts.SCALED_TILE, 24);
                break;
            case 3:
                setImageIndex(1);
                setPlayAreaX(5);
                setY(door.getY());
                getBounds().setBounds(getX() + (Consts.SCALED_TILE - 24), getY(), 24, Consts.SCALED_TILE);
                break;
            default:
                break;
        }
    } 
    
}