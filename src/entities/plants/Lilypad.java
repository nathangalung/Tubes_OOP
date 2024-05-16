package plants;

public class Lilypad extends Plant {
    private boolean is_media;

    public Lilypad(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown) {
        super(0, 0, 1, 1, 5, "Lilypad", 25, 100, 0, 0, 0, 10);
        this.is_media = false;
    }

    public boolean getMedia() {
        return this.is_media;
    }

    public void setMedia(boolean is_media) {
        this.is_media = !is_media;
    }
}