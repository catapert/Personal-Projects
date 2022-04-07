package Pert.Catalin.Lab4.Ex6;

public class Square extends Rectangle {

    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return this.getWidth();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
    @Override
    public void setWidth(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
    @Override
    public String toString() {
        return "A square with side = " + this.getLength() + " which is a subclass of " +super.toString();
    }

    public static void main(String[] args) {
        Square s = new Square(2);
        System.out.println(s.toString());
    }
}
