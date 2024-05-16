package plants;

public class Sunflower extends Plant{
    private boolean isProduceSun ;

    public Sunflower(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown,boolean isProduceSun){
        super(0, 0, 1, 1, 0, "Sunflower", 50, 100, 0, 0, 0, 10);
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
