package Pert.Catalin.Lab11.Ex1;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor TS = new TemperatureSensor();
        Interface I1 = new Interface();
        TS.register(I1);

        new Thread(TS).start();

    }
}
