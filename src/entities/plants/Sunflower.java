package src.entities.plants;

import java.util.TimerTask;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class Sunflower extends Plant implements Item {
    private Sun sun;
    private TimerTask producedSun;
    private ImageIcon[] gifs;

    public Sunflower(int x, int y) {
        super(x, y, 1, 1, "Sunflower", 50, 100, 0, 0, 0, 10);
        this.setGif(GifLoader.loadSunflower());
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
