package Pert.Catalin.Lab5.Ex1;

abstract class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract double getArea();

    abstract double getPerimeter();

    public String toString() {
        String TextFilled;
        if (filled)
            TextFilled = "filled";
        else
            TextFilled = "not filled";
        return "A shape with the color of " + color + " and " + TextFilled;
    }

}
