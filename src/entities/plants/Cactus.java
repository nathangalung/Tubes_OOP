package src.entities.plants;

import java.util.Timer;

import javax.swing.ImageIcon;

import src.assets.GifLoader;
import src.entities.Item;

public class Cactus extends Plant implements Item {
    private Timer actionTimer;
    private ImageIcon[] gifs;

    public Cactus(int x, int y) {
        super(x, y, 1, 1, "Cactus", 200, 300, 2, 2, 0, 10);
        this.setGif(GifLoader.loadCactus());
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
