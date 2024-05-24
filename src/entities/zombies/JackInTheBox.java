package src.entities.zombies;

import javax.swing.ImageIcon;

public class JackInTheBox extends Zombie {
    private ImageIcon[] gifs;
    private boolean isNotExplode = true;

    public JackInTheBox(int x, int y) {
        super(x,  y, 1, 1, "Jack In The Box Zombie", 335, 100, 10, false);
    }

    public void setExplode(){
        isNotExplode = false;
    }

    public boolean getExplode(){
        return isNotExplode;
    }

    @Override
    public ImageIcon[] getGifs() {
        return gifs;
    }
}
