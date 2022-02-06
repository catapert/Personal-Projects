package Pert.Catalin.Lab7.Ex4;

import java.io.*;

public class Main {
    private String StorageFile = "src/main/java/Pert/Catalin/Lab7/Ex4/Cars.txt";


    public static void main(String[] args) {
        Main main = new Main();
        Car C = new Car("Trabant",420);
        main.serializeCar(C);
        System.out.println("Object in file: "+main.deserializeCar());
    }

    private void serializeCar(Car car) {
        try {
            ObjectOutputStream o =
                    new ObjectOutputStream(
                            new FileOutputStream(StorageFile));
            o.writeObject(car);
            System.out.println("The car details have been saved.  --  "+car);
        } catch (IOException e) {
            System.err.println("The car details can't be saved.");
            e.printStackTrace();
        }
    }

    private Car deserializeCar(){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(StorageFile))){
            return (Car) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
