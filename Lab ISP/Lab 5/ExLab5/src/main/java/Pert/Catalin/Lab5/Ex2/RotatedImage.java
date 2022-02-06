package Pert.Catalin.Lab5.Ex2;

public class RotatedImage implements Image{
    public String fileName;

    public RotatedImage(String fileName) {
        fileName = fileName;
    }
    @Override
    public void display() {
        System.out.println("Display rotated " + fileName);
    }
}
