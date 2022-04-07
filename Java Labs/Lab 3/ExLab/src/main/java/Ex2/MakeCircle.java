package Ex2;
import Ex2.Circle;
import java.util.Scanner;

public class MakeCircle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti raza cercului: ");
        double R= in.nextDouble();
        System.out.println("Introduceti culoarea cercului: ");
        String Color = in.next();
        Circle C = new Circle(R,Color);
        System.out.println("The " + C.getColor() + " circle has radius of "
                + C.getRadius() + " and area of " + C.getArea());
    }
}