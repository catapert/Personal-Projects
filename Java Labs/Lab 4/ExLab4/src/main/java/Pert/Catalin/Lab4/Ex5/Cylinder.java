package Pert.Catalin.Lab4.Ex5;
import Pert.Catalin.Lab4.Ex1.Circle;
public class Cylinder extends Circle {
    private double height;
    public Cylinder(){
        this.height=1.0;
    }
    public Cylinder(double radius){
        super(radius);
    }
    public Cylinder(double radius,double height){
        super(radius);
        this.height=height;
    }
    public double getHeight(){
        return height;
    }
    public double getVolume(){
        return super.getArea()*height;
    }
}
