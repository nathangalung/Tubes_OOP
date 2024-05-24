package src.entities.zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;

public class Football extends Zombie {
    private boolean isArmor = true;
    private ImageIcon[] gifs;

    public Football(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x, y, 1, 1, "Football Zombie", 320, 100, 1, false);
        this.setGif(GifLoader.loadFootball());
    }

    public void speedUp(){
        if(isArmor == false){
            setSpeed(getSpeed() + 2);
            setAttackS(getAttackSpeed() + 1);
        }
    }

    public void setisArmor() {
        isArmor = false;
    }

    public boolean getisArmor() {
        return isArmor;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }
}
