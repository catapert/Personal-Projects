package Pert.Catalin.Lab11.Ex1;

import java.util.Random;

public class TemperatureSensor extends Observable implements Runnable {
    Random R = new Random();

    @Override
    public void run() {
        while (true) {
            this.changeState(R.nextInt(65) - 20);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
