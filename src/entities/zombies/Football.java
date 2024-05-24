package zombies;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import zombies.Zombie;

public class Football extends Zombie {
    private boolean isArmor = true;
    private ImageIcon[] gifs;

    public Football(int x, int y, int width, int height, int speed, int direction, boolean is_aquatic, int attack_damage, int attack_speed, int health) {
        super(x, y, 1, 1, 10, -1, false, 100, 1, 320);
        this.setGif(GifLoader.loadFootball());
    }

    public void speedUp(){
        if(isArmor == false){
            setSpeed(getSpeed() + 2);
            setAttackS(getAttackSpeed() + 1);
        }
    }

    public void setisArmor(){
        isArmor = false;
    }

    public boolean getisArmor(){
        return isArmor;
    }

    @Override
    public ImageIcon[] getGif() {
        return gifs;
}
