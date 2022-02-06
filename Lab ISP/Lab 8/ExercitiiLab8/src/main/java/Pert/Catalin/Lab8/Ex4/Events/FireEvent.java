package Pert.Catalin.Lab8.Ex4.Events;

public class FireEvent extends Event {

    private boolean smoke;

    public FireEvent(boolean smoke) {
        super(EventType.FIRE);
        this.smoke = smoke;
    }

    public boolean isSmoke() {
        return smoke;
    }

    @Override
    public String toString() {
        return "FireEvent{" + "smoke=" + smoke + '}';
    }

}