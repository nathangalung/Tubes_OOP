package entities.zombies;

public class DuckyTube extends Zombie {
    protected boolean is_pool = true;

    public DuckyTube(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super("Ducky Tube Zombie", 100, 100, 1, true);
    }

    public boolean getPool(boolean is_pool) {
        return this.is_pool;
    }
}
