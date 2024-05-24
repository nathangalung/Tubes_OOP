package src.entities.plants;

import java.util.Timer;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class TangleKelp extends Plant implements Item {
    private Timer attackTimer1, attackTimer2;
    private boolean isSquashed;
    private ImageIcon[] gifs;

    public TangleKelp(int x, int y) {
        super(x, y, 1, 1, "Tangle Kelp", 25, 100, 0, 0, 0, 20);
        this.setGif(GifLoader.loadTangleKelp());
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
