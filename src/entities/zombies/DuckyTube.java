package src.entities.zombies;
import javax.swing.ImageIcon;


public class DuckyTube extends Zombie {
    private ImageIcon[] gifs;
    protected boolean isPool = false;

    public DuckyTube(int x, int y) {
        super(x,  y, 0, 0, 10, -1, true, 100, 1, 100);
    }

    // public boolean getPool(boolean isPool) {
    //     return this.isPool;
    // }

    // public void setPool(boolean isPool) {
    //     this.isPool = !isPool;
    // }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }
}
