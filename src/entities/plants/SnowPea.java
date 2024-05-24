package src.entities.plants;

import java.awt.Image;
import java.util.Timer;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class SnowPea extends Plant implements Item {
    private Timer actionTimer;
    private ImageIcon[] gifs;
    // private  boolean is_readyAttack = true;
    // protected boolean is_slow = true;

    public SnowPea(int x, int y) {
        super(x, y, 1, 1, "Snow Pea", 175, 100, 25, 4, -1, 10);
        this.setGif(GifLoader.loadSquash());
        actionStart();
    }

    // public boolean getSlow() {
    //     return this.is_slow;
    // }

    @Override
    public ImageIcon[] getGif() {
        return gifs;
    }

    @Override
    public void actionStart() {}

    @Override
    public void actionStop() {}
}