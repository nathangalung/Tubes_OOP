package src.entities.zombies;

import javax.swing.ImageIcon;

public class DolphinRider extends Zombie {
    protected boolean isPool = false;
    private boolean isJump = false;
    private ImageIcon[] gifs;
    
    public DolphinRider(int x, int y) {
        super(x,  y, 1, 1, 10, -1, true, 100, 1, 335);
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
