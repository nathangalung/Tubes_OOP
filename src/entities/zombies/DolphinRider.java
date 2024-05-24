package src.entities.zombies;

import javax.swing.ImageIcon;

public class DolphinRider extends Zombie {
    protected boolean isPool = false;
    private boolean isJump = false;
    private ImageIcon[] gifs;
    
    public DolphinRider(int x, int y) {
        super(x,  y, 1, 1, "Dolphin Rider Zombie", 335, 100, 10, true);
        isJump = false;
    }

    // public boolean getPool(boolean isPool) {
    //     return this.isPool;
    // }

    // public void setPool(boolean isPool) {
    //     this.isPool = !isPool;
    // }

    public boolean getJump() {
        return this.isJump;
    }

    public void setJump(boolean isJump) {
        this.isJump = true;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }
}
