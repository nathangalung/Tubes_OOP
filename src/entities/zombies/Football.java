package zombies;
import zombies.Zombie;

public class Football extends Zombie {
    private boolean isArmor = true;

    public Football(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x,  y, width, height, speed, direction, is_aquatic, attack_damage, attack_speed, health);
    }

    public void speedUp(){
        if(isArmor == false){
            setSpeed(getSpeed()+ 2);
            setAttackS(getAttackSpeed() + 1);
        }
    }

    public void setisArmor(){
        isArmor = false;
    }

    public boolean getisArmor(){
        return isArmor;
    }
}
