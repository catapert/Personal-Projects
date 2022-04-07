package Pert.Catalin.Lab5.Ex3;
import Pert.Catalin.Lab5.Ex3.LightSensor;
import Pert.Catalin.Lab5.Ex3.TemperatureSensor;
public class Controller {
    private LightSensor LS = new LightSensor();
    private TemperatureSensor TS = new TemperatureSensor();
    public void control() throws InterruptedException{
        for (int i=0; i<=20; i++){
            System.out.println(TS.readValue());
            System.out.println(LS.readValue());
            Thread.sleep(1000);
        }
    }
}
