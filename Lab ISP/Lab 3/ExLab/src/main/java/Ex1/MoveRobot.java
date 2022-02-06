package Ex1;

import java.util.Scanner;
import Ex1.Robot;

public class MoveRobot {
    public static void main(String[] args) {
        Robot R=new Robot();
        System.out.println("The robot start on positon: 1");
        Scanner in = new Scanner(System.in);
        System.out.println("Choose how many positons to moves the robot: ");
        int k=in.nextInt();
        System.out.println("The robot is on the positon: "+R.AddK(k));
    }
}