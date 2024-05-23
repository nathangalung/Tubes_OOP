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
        for (int i = 0; i < 6; i++) {
            PINK_TILES[i] = new Point(70, 70 + (i*110));
            BROWN_TILES[i] = new Point(1070, 70 + (i*110));
        }

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 9; k++) {
                if (j < 2) BLUE_TILES[j*9 + k] = new Point(170 + (k*100), 70 + (j*110));
                GREEN_TILES[j*9 + k] = new Point(170 + (k*100), 70 + (j*110));
            }
        }

        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 9; x++) {
                if (y < 2) GREEN_TILES[y*9 + x] = new Point(170 + (x*100), 75 + (y*108));
                else if (y >= 4) GREEN_TILES[(y-2)*9 + x] = new Point(170 + (x*100), 75 + (y*108));
                else BLUE_TILES[(y-2)*9 + x] = new Point(170 + (x*100), 75 + (y*108));
            }
            PINK_TILES[y] = new Point(70, 75 + (y*108)); 
            BROWN_TILES[y] = new Point(1070, 75 + (y*108)); 
        }
    }
    public static final int SECOND = 1;
    public static final int MORNING = 100;
    public static final int NIGHT = 100;
    public static final int DAY = 200;
    public static final int GAME = 250;

    // FOR THREADS
    public static final int THREAD_ONE_SECOND = 1000;
    public static final int THREAD_ONE_DAY = 160 * THREAD_ONE_SECOND;
    public static final int THREAD_MORNING = 100 * THREAD_ONE_SECOND;
    public static final int THREAD_NIGHT = 100 * THREAD_ONE_SECOND;
    
}
