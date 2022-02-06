package Pert.Catalin.Lab10.Ex4;

import java.util.Objects;

public class Robot {
    private int coordX;
    private int coordY;

    public Robot(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return coordX == robot.coordX && coordY == robot.coordY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordX, coordY);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "X=" + coordX +
                ", Y=" + coordY +
                '}' + '\n';
    }
}
