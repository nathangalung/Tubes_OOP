package src.entities.zombies;

import javax.swing.ImageIcon;

public class Newspaper extends Zombie {
    private static int paper = 150;
    private boolean isPaper = true;
    private ImageIcon[] gifs;

    public Newspaper(int x, int y) {
        super(x,  y, 1, 1, 10, 3, false, 100, 1, 181);
        setHealth(181 + paper);
    }

    public void speedUp() {
        if(isPaper == false){
            setSpeed(getSpeed()+ 2);
            setAttackS(getAttackSpeed() + 1);
        }
    }

    public boolean getIsPaper(){
        return isPaper;
    }

    public void setIsPaper(){
        isPaper = false;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }

}
