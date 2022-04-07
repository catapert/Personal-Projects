package Pert.Catalin.Lab5.Ex4;

import Pert.Catalin.Lab5.Ex3.LightSensor;
import Pert.Catalin.Lab5.Ex3.TemperatureSensor;
public class Controller {
    private static Controller Ctrl;

    public Controller() {
    }

    public static Controller getController() {
        if(Ctrl == null){
            Ctrl = new Controller();
        }
        return Ctrl;
    }

    private LightSensor LS = new LightSensor();
    private TemperatureSensor TS = new TemperatureSensor();
    void control() throws InterruptedException{
        for (int i=0; i<=20; i++){
            System.out.println(TS.readValue());
            System.out.println(LS.readValue());
            Thread.sleep(1000);
        }
    }
}
