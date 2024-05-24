package zombies;

import zombies.Zombie;

public class Buckethead extends Zombie {
    private boolean isBucket = true;

    public Buckethead(int x, int y) {
        super(x,  y, 1, 1, 1, -1, false, 100, 1, 300);

    }

    public boolean getIsBucket() {
        return this.isBucket;
    }

    public void setIsBucket(boolean is_cone) {
        this.isBucket = false;
    }
}