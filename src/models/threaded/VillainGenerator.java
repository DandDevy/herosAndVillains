package models.threaded;

import controllers.Controller;

import java.util.concurrent.TimeUnit;

public class VillainGenerator implements Runnable {
    private int delay;
    private String type, strength;

    public VillainGenerator(int delay, String type, String strength) {
        this.delay = delay;
        this.type = type;
        this.strength = strength;
    }

    @Override
    public void run() {
        while (true){
            Controller.addVillain(type, strength);
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
