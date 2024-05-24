package src.entities.plants;

import java.util.Timer;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class CherryBomb extends Plant implements Item {
    private Timer actionTimer1, actionTimer2;
    private ImageIcon[] gifs;

    public CherryBomb(int x, int y) {
        super(x, y, 1, 1, "Cherry Bomb", 150, 1000, 1800, 1, 1, 30);
        this.setGif(GifLoader.loadCherryBomb());
        actionStart();
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
