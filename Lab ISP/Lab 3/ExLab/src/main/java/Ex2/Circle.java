package Ex2;

public class Circle {
    private double radius;
    private String color;
    public Circle(){
        radius = 1.0;
        color = "red";
    }
    public Circle(double r, String cl) {
        radius = r;
        color = cl;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return radius*radius*Math.PI;
    }
    public String getColor() {
        return color;
    }
}