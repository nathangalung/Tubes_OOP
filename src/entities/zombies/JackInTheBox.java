package zombies;
import zombies.Zombie;

public class JackInTheBox extends Zombie {
    private boolean isNotExplode = true;

    public JackInTheBox(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x,  y, width, height, speed, direction, is_aquatic, attack_damage, attack_speed, health);
    }

    public void setExplode(){
        isNotExplode = false;
    }

    public boolean getExplode(){
        return isNotExplode;
    }
}
