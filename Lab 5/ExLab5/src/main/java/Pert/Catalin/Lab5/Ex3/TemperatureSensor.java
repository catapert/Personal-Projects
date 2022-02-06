package Pert.Catalin.Lab5.Ex3;


public class TemperatureSensor extends Sensor {

    @Override
    public int readValue(){
        return (int)(Math.random() * 100);
    }
}
