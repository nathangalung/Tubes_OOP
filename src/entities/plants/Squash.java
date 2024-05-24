package src.entities.plants;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class Squash extends Plant implements Item {
    private Timer attackTimer1, attackTimer2;
    private boolean isSquashed;
    private ImageIcon[] gifs;

    public Squash(int x, int y) {
        super(
            x, 
            y, 
            1, 
            1, 
            "Squash", 
            50, 
            100, 
            5000, 
            1, 
            1, 
            20
        );
        
        getBounds().setSize(64, 64);
        this.setGif(GifLoader.loadSquash());
        actionStart();

        // images = ImageLoader.loadSquash();
    }

    public boolean getSquash() {
        return this.isSquashed;
    }

    public void setSquash(boolean isSquash) {
        this.isSquashed = !this.isSquashed;
    }

    
    @Override
    public ImageIcon[] getGif() {
        return gifs;
        
    }

    @Override
    public void actionStart() {
        attackTimer1 = new Timer();
        attackTimer1.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (isSquashed) {
                    attackTimer1.cancel();
                    attackTimer2 = new Timer();
                    attackTimer2.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            setHealth(0);
                        }
                    }, 200);
                }
            }
        }, 0, 100);
    }

    @Override
    public void actionStop() {}

    // private void animateNotOccupied() {
    //     animateNotOccupiedThread = new Thread() {
    //         @Override
    //         public void run() {
    //             while (!isOccupied()) {
    //                 try {
    //                     setImageIndex(0);
    //                     Thread.sleep(Consts.THREAD_ONE_SECOND);
    //                     setImageIndex(1);
    //                     Thread.sleep(Consts.THREAD_ONE_SECOND);
    //                 }
    //                 catch (InterruptedException ie) {}
    //             }
    //         }
    //     };
    //     animateNotOccupiedThread.start();
    // }

    // private void animateOccupied(Zombie zombie) {
    //     animateOccupiedThread = new Thread() {
    //         @Override
    //         public void run() {
    //             images[2] = ImageLoader.changezombieColor(images[2], zombie);
    //             images[3] = ImageLoader.changezombieColor(images[3], zombie);
    //             while (isOccupied()) {
    //                 try {
    //                     setImageIndex(2);
    //                     Thread.sleep(Consts.THREAD_ONE_SECOND);
    //                     setImageIndex(3);
    //                     Thread.sleep(Consts.THREAD_ONE_SECOND);
    //                 }
    //                 catch (InterruptedException ie) {}
    //             }
    //         }
    //     };
    //     animateOccupiedThread.start();
    // }

    // @Override
    // public void changeOccupiedState() {
    //     this.occupied = !this.occupied;
    // }

    // @Override
    // public BufferedImage getIcon() {
    //     return icon;
    // }

    // @Override
    // public BufferedImage getImage() {
    //     return images[getImageIndex()];
    // }

    // @Override
    // public void interact (Zombie zombie) {
    //     Thread squash = new Thread() {
    //         @Override
    //         public void run() {
    //             changeOccupiedState();
    //             zombie.setStatus(activityStatus);

    //             animateNotOccupiedThread.interrupt();
    //             animateOccupied(zombie);
                
    //             GameTime.addActivityTimer(zombie, activityStatus, duration, duration);

    //             while (GameTime.isAlive(zombie, activityStatus)) continue;

    //             changeOccupiedState();
    //             animateNotOccupied();
    //             zombie.resetStatus();

    //             // reset the images
    //             images = ImageLoader.loadSquash();
    //         }
    //     };
    //     squash.start();
    // }

}