package zombies;
import zombies.Zombie;

public class Newspaper extends Zombie {
    private static int paper = 100 ;
    private boolean isPaper = true;

    public Newspaper(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x,  y, width, height, speed, direction, is_aquatic, attack_damage, attack_speed, health);
        setHealth(health + paper);
    }

    public void speedUp(){
        if(isPaper == false){
            setSpeed(getSpeed()+ 2);
            setAttackS(getAttackSpeed() + 1);
        }
    }

    public boolean getisPaper(){
        return isPaper;
    }

    public void setisPaper(){
        isPaper = false;
    }

}
