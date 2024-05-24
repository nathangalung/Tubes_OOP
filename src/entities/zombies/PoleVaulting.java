package src.entities.zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class PoleVaulting extends Zombie {
    private boolean is_jump = false;
    private ImageIcon[] gifs;

    public PoleVaulting(int x, int y) {
        super(x, y, 1, 1, 10, -1, false, 100, 1, 175);
        this.setGif(GifLoader.loadPoleVaulting());
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = true;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }
}