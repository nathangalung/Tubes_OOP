package plant;

public class Sunflower extends Plant{
    private boolean isProduceSun ;

    public Sunflower(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown,boolean isProduceSun){
        super(name, cost, health, attack_damage, attack_speed, range, cooldown);
        this.isProduceSun = isProduceSun;
    }

    public void produceSun(Sun sun){
        sun.sunGenerate();
    }

    public void set_isProduceSun(boolean bool){
        isProduceSun = bool;
    }

    public boolean get_isProduceSun(){
        return isProduceSun;
    }
}
