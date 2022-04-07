package Pert.Catalin.Lab8.Ex4.Events;


public class TemperatureEvent extends Event {

    private int vlaue;

    public TemperatureEvent(int vlaue) {
        super(EventType.FIRE.TEMPERATURE);
        this.vlaue = vlaue;
    }

    public int getValue() {
        return vlaue;
    }

    @Override
    public String toString() {
        return "TemperatureEvent{" + "vlaue=" + vlaue + '}';
    }

}
