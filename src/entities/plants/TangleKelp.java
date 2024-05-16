package plants;

public class TangleKelp extends Plant {
    private boolean is_tangle;

    public TangleKelp(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(0, 0, 1, 1, 6, "Tangle Kelp", 25, 100, 0, 0, 0, 20);
        this.is_tangle = false;
    }

    public boolean getTangle() {
        return this.is_tangle;
    }

    public void setTangle(boolean is_tangle) {
        this.is_tangle = true;
    }
}
