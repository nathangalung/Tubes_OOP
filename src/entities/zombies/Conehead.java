package src.entities.zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class Conehead extends Zombie {
    private boolean isCone = true;
    private ImageIcon[] gifs;

    public Conehead(int x, int y) {
        super(x,  y, 1, 1, "Conehead Zombie", 250, 100, 1, false);
        this.isCone = true;
        this.setGif(GifLoader.loadConehead());
    }

    public boolean getCone() {
        return this.isCone;
    }

    public void setCone(boolean isCone) {
        this.isCone = false;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }

}
