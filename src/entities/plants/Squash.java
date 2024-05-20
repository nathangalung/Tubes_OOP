package src.entities.plants;

import java.awt.image.BufferedImage;

import src.assets.ImageLoader;
import src.entities.zombies.Zombie;
import src.main.Consts;
import src.main.time.GameTime;

public class Squash extends Plant {
    private boolean isSquash;
    private Thread animateNotOccupiedThread;
    private Thread animateOccupiedThread;

    private BufferedImage[] images;

    public Squash(int x, int y) {
        super(
            x, 
            y, 
            1, 
            1, 
            4, 
            "Squash", 
            50, 
            100, 
            5000, 
            1, 
            1, 
            20
        );
        
        isSquash = false;
        getBounds().setSize(64, 64);

        images = ImageLoader.loadSquash();
    }

    public boolean getSquash() {
        return this.isSquash;
    }

    public void setSquash(boolean is_squash) {
        this.isSquash = true;
    }

    private void animateNotOccupied() {
        animateNotOccupiedThread = new Thread() {
            @Override
            public void run() {
                while (!isOccupied()) {
                    try {
                        setImageIndex(0);
                        Thread.sleep(Consts.THREAD_ONE_SECOND);
                        setImageIndex(1);
                        Thread.sleep(Consts.THREAD_ONE_SECOND);
                    }
                    catch (InterruptedException ie) {}
                }
            }
        };
        animateNotOccupiedThread.start();
    }

    private void animateOccupied(Zombie zombie) {
        animateOccupiedThread = new Thread() {
            @Override
            public void run() {
                images[2] = ImageLoader.changezombieColor(images[2], zombie);
                images[3] = ImageLoader.changezombieColor(images[3], zombie);
                while (isOccupied()) {
                    try {
                        setImageIndex(2);
                        Thread.sleep(Consts.THREAD_ONE_SECOND);
                        setImageIndex(3);
                        Thread.sleep(Consts.THREAD_ONE_SECOND);
                    }
                    catch (InterruptedException ie) {}
                }
            }
        };
        animateOccupiedThread.start();
    }

    @Override
    public void changeOccupiedState() {
        this.occupied = !this.occupied;
    }

    @Override
    public BufferedImage getIcon() {
        return icon;
    }

    @Override
    public BufferedImage getImage() {
        return images[getImageIndex()];
    }

    @Override
    public void interact (Zombie zombie) {
        Thread squash = new Thread() {
            @Override
            public void run() {
                changeOccupiedState();
                zombie.setStatus(activityStatus);

                animateNotOccupiedThread.interrupt();
                animateOccupied(zombie);
                
                GameTime.addActivityTimer(zombie, activityStatus, duration, duration);

                while (GameTime.isAlive(zombie, activityStatus)) continue;

                changeOccupiedState();
                animateNotOccupied();
                zombie.resetStatus();

                // reset the images
                images = ImageLoader.loadSquash();
            }
        };
        squash.start();
    }
}