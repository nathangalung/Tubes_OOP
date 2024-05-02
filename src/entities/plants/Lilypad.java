package entities.plants;

public class Lilypad extends Plant {
    private boolean is_media;

    public Lilypad(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super("Lilypad", 25, 100, 0, 0, 0, 10);
        this.is_media = true;
    }

    public boolean getMedia() {
        return this.is_media;
    }

    public void setMedia(boolean is_media) {
        this.is_media = false;
    }
}