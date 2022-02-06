package Pert.Catalin.Lab8.Ex4.Events;



public class NoEvent extends Event {

    public NoEvent() {
        super(EventType.NONE);
    }

    @Override
    public String toString() {
        return "NoEvent{}";
    }
}
