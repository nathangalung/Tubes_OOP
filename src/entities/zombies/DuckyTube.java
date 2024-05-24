package src.entities.zombies;
import javax.swing.ImageIcon;


public class DuckyTube extends Zombie {
    private ImageIcon[] gifs;
    protected boolean isPool = false;

    public DuckyTube(int x, int y) {
        super(x,  y, 1, 1, "Duckytube Zombie", 100, 100, 10, true);
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
