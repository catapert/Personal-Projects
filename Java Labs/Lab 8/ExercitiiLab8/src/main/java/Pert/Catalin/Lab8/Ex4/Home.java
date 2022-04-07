package Pert.Catalin.Lab8.Ex4;

import Pert.Catalin.Lab8.Ex4.Events.Event;
import Pert.Catalin.Lab8.Ex4.Events.FireEvent;
import Pert.Catalin.Lab8.Ex4.Events.NoEvent;
import Pert.Catalin.Lab8.Ex4.Events.TemperatureEvent;


import java.util.Random;

public abstract class Home {
    private final int SIMULATION_STEPS = 20;
    protected static final Random rand = new Random();

    protected abstract void setValueInEnvironment(Event event);

    protected abstract void controlStep();

    private Event getHomeEvent() {
        //randomly generate a new event;
        int k = rand.nextInt(100);
        if (k < 30)
            return new NoEvent();
        else if (k < 60)
            return new FireEvent(rand.nextBoolean());
        else
            return new TemperatureEvent(rand.nextInt(50));
    }

    public void simulate() {
        int k = 0;
        while (k < SIMULATION_STEPS) {
            Event event = this.getHomeEvent();
            setValueInEnvironment(event);
            controlStep();

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            k++;
        }
    }

}