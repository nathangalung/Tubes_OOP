package src.mains.times;

import src.entities.plants.Plant;

public class CooldownTimer {
    private Plant plant;
    private int dayRemaining;
    private int timeRemaining;
    private int duration;

    public CooldownTimer(Plant plant, int dayRemaining, int timeRemaining, int duration) {
        this.plant = plant;
        this.dayRemaining = dayRemaining;
        this.timeRemaining = timeRemaining;
        this.duration = duration;
    }

    public Plant getPlant() {
        return plant;
    }

    public int getDayRemaining() {
        return dayRemaining;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public int getDuration() {
        return duration;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public void setDayRemaining(int dayRemaining) {
        this.dayRemaining = dayRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
