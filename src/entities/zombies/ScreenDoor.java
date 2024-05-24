package zombies;

public class ScreenDoor extends Zombie {
    private boolean isShield = true;

    public ScreenDoor(int x, int y) {
        super(x, y, 1, 1, 1, -1,false, 1500, 0, 300 );
    }

    public void setShield(){
        isShield = false;
    }

    public boolean getShield(){
        return isShield;
    }

}

