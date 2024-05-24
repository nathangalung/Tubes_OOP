package src.entities.plants;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class Lilypad extends Plant implements Item {
    private ImageIcon[] gifs;

    public Lilypad(int x, int y) {
        super(x, y,  1, 1, "Lilypad", 25, 100, 0, 0, 0, 10);
        this.setGif(GifLoader.loadLilypad());
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