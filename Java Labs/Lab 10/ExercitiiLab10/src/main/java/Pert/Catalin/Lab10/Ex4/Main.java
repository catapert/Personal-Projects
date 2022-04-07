package Pert.Catalin.Lab10.Ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Robot> robots = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {

            robots.add(new Robot(0,i));
        }
        MoveRobot moveRobot = new MoveRobot(robots);
        VerifyRobot verifyRobot = new VerifyRobot(robots);

        moveRobot.start();
        verifyRobot.start();
    }
}
