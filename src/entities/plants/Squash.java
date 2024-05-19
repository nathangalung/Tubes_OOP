package src.entities.plants;

import java.awt.image.BufferedImage;

import src.assets.ImageLoader;
import src.entities.sim.Sim;
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
                images[2] = ImageLoader.changeSimColor(images[2], sim);
                images[3] = ImageLoader.changeSimColor(images[3], sim);
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
    public void interact (Sim sim){
        Thread feedingfish = new Thread() {
            @Override
            public void run() {
                changeOccupiedState();
                sim.setStatus(activityStatus);

                animateNotOccupiedThread.interrupt();
                animateOccupied(sim);
                
                GameTime.addActivityTimer(sim, activityStatus, duration, duration);

                while (GameTime.isAlive(sim, activityStatus)) continue;

                changeOccupiedState();
                animateNotOccupied();
                sim.resetStatus();
                sim.setMood(sim.getMood() + 5); // increase sim's mood

                // reset the images
                images = ImageLoader.loadAquarium();
            }
        };
        feedingfish.start();
    }
}