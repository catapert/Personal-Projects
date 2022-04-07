package Pert.Catalin.Lab8.Ex4.Events;


public abstract class Event {

    private EventType type;

    Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return this.type;
    }

}