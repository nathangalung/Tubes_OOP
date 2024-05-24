package zombies;

import zombies.Zombie;

public class Conehead extends Zombie {
    private boolean isCone = true;

    public Conehead(int x, int y) {
        super(x,  y, 0, 0, 1, -1, false,100, 1, 250);
        this.isCone = true;
    }

    public boolean getCone() {
        return this.isCone;
    }

    public void setCone(boolean isCone) {
        this.isCone = false;
    }
}
