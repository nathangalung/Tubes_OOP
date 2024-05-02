package plant;

public class Lilypad extends Plant {
    private boolean is_media;

    public Lilypad(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(name, cost, health, attack_damage, attack_speed, range, cooldown);
        this.is_media = true;
        
    }

    public boolean getMedia() {
        return this.is_media;
    }

    public void setMedia(boolean is_media) {
        this.is_media = false;
    }
}
