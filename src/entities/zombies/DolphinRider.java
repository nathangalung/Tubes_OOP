package zombiest;

public class DolphinRider extends Zombie {
    protected boolean isPool = false;
    private boolean isJump;
    
    public DolphinRider(String name, int health, int attack_damage, int attack_speed, boolean isAquatic) {
        super(0, 0, 1, 1, 5, "Dolphin Rider Zombie", 175, 100, 1, true);
        isJump = false;
    }

    public boolean getPool(boolean isPool) {
        return this.isPool;
    }

    public void setPool(boolean isPool) {
        this.isPool = !isPool;
    }

    public boolean getJump() {
        return this.isJump;
    }

    public void setJump(boolean isJump) {
        this.isJump = true;
    }
}
