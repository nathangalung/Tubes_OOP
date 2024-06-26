package src.mains;

import java.awt.Point;

public abstract class Consts {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final Point[] PINK_TILES = new Point[6];
    public static final Point[] GREEN_TILES = new Point[36];
    public static final Point[] BLUE_TILES = new Point[18];
    public static final Point[] BROWN_TILES = new Point[6];

    static {

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 9; x++) {
                if (y < 2) GREEN_TILES[y*9 + x] = new Point(170 + (x*101), 80 + (y*108));
                else if (y >= 4) GREEN_TILES[(y-2)*9 + x] = new Point(170 + (x*101), 80 + (y*108));
                else BLUE_TILES[(y-2)*9 + x] = new Point(170 + (x*101), 80 + (y*108));
            }
            PINK_TILES[y] = new Point(70, 80 + (y*108)); 
            BROWN_TILES[y] = new Point(1070, 80 + (y*108)); 
        }
    }
    public static final int SECOND = 1;
    public static final int MORNING = 100;
    public static final int NIGHT = 100;
    public static final int DAY = 200;
    public static final int GAME = 250;
    public static final int ZOMBIE_SPAWN_START = 20;
    public static final int ZOMBIE_SPAWN_END = 160;

    // FOR THREADS
    public static final int THREAD_ONE_SECOND = 1000;
    public static final int THREAD_ONE_GAME = 250 * THREAD_ONE_SECOND;
    public static final int THREAD_ONE_DAY = 200 * THREAD_ONE_SECOND;
    public static final int THREAD_MORNING = 100 * THREAD_ONE_SECOND;
    public static final int THREAD_NIGHT = 100 * THREAD_ONE_SECOND;
    
}
