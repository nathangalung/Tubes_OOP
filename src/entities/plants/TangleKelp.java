package plants;

public class TangleKelp extends Plant {
    private boolean is_tangle;

    public TangleKelp(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super("Tangle Kelp", 25, 100, 0, 0, 0, 10, false);
        this.is_tangle = false;
    }

    public boolean getTangle() {
        return this.is_tangle;
    }

    public void setTangle(boolean is_tangle) {
        this.is_tangle = true;
    }
}
