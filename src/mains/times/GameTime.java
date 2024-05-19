package src.mains.times;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import src.entities.plants.Plant;
import src.mains.Consts;
import src.mains.UserInterface;
import src.maps.Map;

public class GameTime implements Runnable {
    private static GameTime gt = new GameTime();
    private static Thread gtThread = new Thread(gt);

    // public static int DAY_DURATION = Consts.SECOND * Consts.DAY;
    // public static int MORNING_DURATION = Consts.SECOND * Consts.MORNING;
    // public static int NIGHT_DURATION = Consts.SECOND * Consts.NIGHT;
    // public static int ZOMBIE_SPAWN_START = Consts.SECOND * 20;
    // public static int ZOMBIE_SPAWN_END = Consts.SECOND * 160;

    public static int day;
    public static int dayRemaining = Consts.SECOND * Consts.DAY;
    public static int timeRemaining = Consts.SECOND * Consts.GAME;
    public static int morningRemaining = Consts.SECOND * Consts.MORNING;
    public static int nightRemaining = Consts.SECOND * Consts.NIGHT;

    private static ArrayList<CooldownTimer> cooldownPlantsList = new ArrayList<>();

    private GameTime() {}

    public static void init(int day, int dayRemaining, int timeRemaining, int morningRemaining, int nightRemaining) {
        GameTime.day = day;
        GameTime.dayRemaining = dayRemaining;
        GameTime.timeRemaining = timeRemaining;
        GameTime.morningRemaining = morningRemaining;
        GameTime.nightRemaining = nightRemaining;

        if (!gtThread.isAlive()) {
            gtThread.start();
        }
    }

    // GETTERS
    public static GameTime getInstance() {
        return gt;
    }

    public static Thread getThreadInstance() {
        return gtThread;
    }

    public static ArrayList<CooldownTimer> getCooldownPlantsList() {
        return cooldownPlantsList;
    }

    public static CooldownTimer getcooldownTimer(Plant plant, String activity) {
        try {
            for (CooldownTimer cooldownTimer : cooldownPlantsList) {
                Plant cooldownPlant = cooldownTimer.getPlant();

                boolean isPlantCooldown = plant.getName().equals(cooldownPlant.getName());

                if (isPlantCooldown) {
                    return cooldownTimer;
                }
            }
        }
        catch (ConcurrentModificationException cme) {

        }

        return null;
    }

    // IMPLEMENTATION OF INTERFACE
    @Override
    public void run() {
        while (gtThread.isAlive()) {
            if (UserInterface.isPaused()) continue;
            if (cooldownPlantsList.isEmpty()) continue;

            try {
                Thread.sleep(Consts.THREAD_ONE_SECOND);

                for (CooldownTimer cooldownTimer : cooldownPlantsList) {
                    int dayRemaining = cooldownTimer.getDayRemaining();

                    if (dayRemaining <= 0) cooldownPlantsList.remove(cooldownTimer);

                    cooldownTimer.setDayRemaining(dayRemaining - 1);
                }
                decrementDayRemaining();

                Map map = UserInterface.getMap();
                ArrayList<Plant> plantsList = map.getPlantsList();

                for (Plant plant : plantsList) {
                    int timeNotSlept = plant.getTimeNotSlept();
                    int timeNotTakenLeak = plant.getTimeNotTakenLeak();

                    plant.setTimeNotSlept(timeNotSlept + 1);
                    plant.setTimeNotTakenLeak(timeNotTakenLeak + 1);
                }
            }
            catch (InterruptedException ie) {}
            catch (ConcurrentModificationException cme) {}
        }
    }

    public static boolean isAlive(Plant plant, String activity) {
        if (cooldownPlantsList.isEmpty()) return false;

        boolean isAlive = false;
        try {
            for (CooldownTimer cooldownTimer : cooldownPlantsList) {
                Plant cooldownPlant = cooldownTimer.getPlant();

                boolean isPlantCooldown = plant.getName().equals(cooldownPlant.getName());
                boolean activityIsActive = activity.equals(cooldownTimer.getActivity());

                if (isPlantCooldown && activityIsActive) {
                    isAlive = true;
                }
            }
        }
        catch (ConcurrentModificationException cme) {}
        catch (NullPointerException npe) {}

        return isAlive;
    }

    // SETTERS
    public static void addcooldownTimer(Plant plant, String activity, int dayRemaining, int duration) {
        CooldownTimer cooldownTimer = new CooldownTimer(plant, dayRemaining, timeRemaining, duration);
        cooldownPlantsList.add(cooldownTimer);
    }

    public static void decrementDayRemaining() {
        dayRemaining--;
        if (dayRemaining == 0) {
            dayRemaining = timeRemaining;
            incrementDay();
        }
    }

    public static void incrementDay() {
        day++;
    }

    public static void decreaseDayRemaining(int time) {
        dayRemaining -= time;

        for (CooldownTimer cooldownTimer : cooldownPlantsList) {
            int dayRemaining = cooldownTimer.getDayRemaining();

            cooldownTimer.setDayRemaining(dayRemaining - time);
        }

        Map map = UserInterface.getPlant();
        ArrayList<Plant> plantsList = map.getPlantsList();

        for (Plant plant : plantsList) {
            int timeNotSlept = plant.getTimeNotSlept();
            int timeNotTakenLeak = plant.getTimeNotTakenLeak();

            Plant.setTimeNotSlept(timeNotSlept + time);
            Plant.setTimeNotTakenLeak(timeNotTakenLeak + time);
        }

        if (dayRemaining <= 0) {
            int timeLeft = 0 - dayRemaining;
            dayRemaining = timeRemaining - timeLeft;
            incrementDay();
        }
    }
}