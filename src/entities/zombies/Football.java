package zombiest;

public class Football extends Zombie {
    public Football(String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        super(0, 0, 1, 1, 8, "Football Zombie", health, attack_damage, attack_speed, is_aquatic);
    }
}