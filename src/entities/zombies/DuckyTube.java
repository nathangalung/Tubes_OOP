package zombies;
import zombies.Zombie;

public class DuckyTube extends Zombie {
    protected boolean isPool = false;

    public DuckyTube(int x, int y) {
        super(x,  y, 0, 0, 1, -1, true, 100, 1, 100);
    }

    // public boolean getPool(boolean isPool) {
    //     return this.isPool;
    // }

    // public void setPool(boolean isPool) {
    //     this.isPool = !isPool;
    // }
}
