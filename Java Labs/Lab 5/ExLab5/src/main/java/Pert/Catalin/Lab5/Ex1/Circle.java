package Pert.Catalin.Lab5.Ex1;

public class Circle extends Shape{
    private double radius;
    public Circle(){
        this.radius=1.0;
    }
    public Circle(double radius,String color, boolean filled){
        super(color,filled);
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    @Override
    public double getArea(){
        return radius*radius*Math.PI;
    }
    @Override
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public String toString(){
        return "A circle with radius = "+radius+ ", which is a subclass of "+super.toString();
    }
}
