package src.entities.zombies;

import javax.swing.ImageIcon;

public class JackInTheBox extends Zombie {
    private ImageIcon[] gifs;
    private boolean isNotExplode = true;

    public JackInTheBox(int x, int y) {
        super(x,  y, 1, 1, 10, 3, true, 100, 1, 335);
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
