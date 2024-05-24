package src.entities.plants;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class WallNut extends Plant implements Item {
    private Thread animateNotOccupiedThread;
    private Thread animateOccupiedThread;
    private ImageIcon[] gifs;
    private BufferedImage images;

    public WallNut(int x, int y) {
        super(
            x, 
            y, 
            1, 
            1, 
            "WallNut", 
            50, 
            100, 
            5000, 
            1, 
            1, 
            20
        );
        getBounds().setSize(64, 64);
        this.setGif(GifLoader.loadWallNut());

        // images = ImageLoader.loadWallNut();
    }

	@Override
    public ImageIcon[] getGif() {
        return gifs;
    }

    @Override
    public void actionStart() {}

    @Override
    public void actionStop() {}
}