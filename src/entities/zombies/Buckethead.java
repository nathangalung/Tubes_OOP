package zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import zombies.Zombie;

public class Buckethead extends Zombie {
    private boolean isBucket = true;
    private ImageIcon[] gifs;

    public Buckethead(int x, int y) {
        super(x,  y, 1, 1, 1, -1, false, 100, 1, 300);
        this.setGif(GifLoader.loadBuckethead);
    }

    public boolean getIsBucket() {
        return this.isBucket;
    }

    public void setIsBucket(boolean is_cone) {
        this.isBucket = false;
    }

    @Override
    public ImageIcon[] getGif() {
        return gifs;
    }
}