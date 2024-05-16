package zombiest;

public class DuckyTube extends Zombie {
    protected boolean isPool = false;

    public DuckyTube(String name, int health, int attack_damage, int attack_speed, boolean isAquatic) {
        super(0, 0, 1, 1, 4, "Ducky Tube Zombie", 100, 100, 1, true);
    }

    public boolean getPool(boolean isPool) {
        return this.isPool;
    }

    public void setPool(boolean isPool) {
        this.isPool = !isPool;
    }
}
