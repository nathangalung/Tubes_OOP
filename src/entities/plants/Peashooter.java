package src.entities.plants;

import java.util.List;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class Peashooter extends Plant implements Item {
    private Timer actionTimer;
    private ImageIcon[] gifs;

    public Peashooter(int x, int y) {
        super(x, y, 1, 1, "Peashooter", 100, 100, 25, 4, -1, 10);
        this.setGif(GifLoader.loadPeashooter());
        actionStart();
    } 

    @Override
    public ImageIcon[] getGif() {
        return gifs;
    }

    @Override
    public void actionStart() {}

    @Override
    public void actionStop() {}

    // public void action() {
    //     // ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    //     // executor.scheduleAtFixedRate(() -> {
    //     //     List<Zombie> zombies = getZombiesInLane();
    //     //     if (zombies.size() > 0) {
    //     //         Pea pea = new Pea((int) this.getX() + 50, (int) this.getY(), "Normal");
    //     //         pea.setLane((int) this.getY());
    //     //         addPea(pea);
    //     //     }
    //     // }, 0, 2000, TimeUnit.MILLISECONDS);
    // }
}
