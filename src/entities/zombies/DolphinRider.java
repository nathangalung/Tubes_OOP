package zombies;

public class DolphinRider extends Zombie {
    protected boolean isPool = false;
    private boolean isJump = false;
    
    public DolphinRider(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x,  y, 0, 0, 1, -1, true, 100, 100, 175);
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
}
