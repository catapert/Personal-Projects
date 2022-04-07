package Pert.Catalin.Lab5.Ex3;

abstract class Sensor {
    private String location;

    abstract int readValue();

    public String getLocation() {
        return location;
    }
}
