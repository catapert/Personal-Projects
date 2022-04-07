package Pert.Catalin.Lab5.Ex2;

public class ProxyImage implements Image {

    private RealImage realImage;
    private RotatedImage rotatedImage;
    private boolean rotated;
    private String fileName;

    public ProxyImage(boolean rotated, String fileName) {
        this.rotated = rotated;
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else if (rotatedImage == null) {
            rotatedImage = new RotatedImage(fileName);
        } else if (rotated) {
            rotatedImage.display();
        } else{
            realImage.display();
        }
    }
}
