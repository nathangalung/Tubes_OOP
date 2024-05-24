package src.entities.zombies;

public class PoleVaulting extends Zombie {
    private boolean is_jump = false;

    public PoleVaulting(int x, int y) {
        super(x, y, 1, 1, 2, -1, false, 100, 1, false);
    }

    public boolean getJump() {
        return this.is_jump;
    }

    public void setJump(boolean is_jump) {
        this.is_jump = true;
    }
}
