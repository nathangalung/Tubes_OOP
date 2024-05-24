package src.entities.plants;

import java.util.Timer;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class Jalapeno extends Plant {
    private Timer actionTimer1, actionTimer2;
    private ImageIcon[] gifs;

    public Jalapeno(int x, int y) {
        super(x, y, 1, 1, "Jalapeno", 125, 1000, 1800, 1, -1, 30);
        this.setGif(GifLoader.loadJalapeno());
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
