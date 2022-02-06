package Pert.Catalin.Lab10.Ex4;

import java.util.List;

public class MoveRobot extends Thread {
    private final List<Robot> robots;

    public MoveRobot(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public void run() {
        while (!robots.isEmpty()){
            synchronized (robots) {
                for (Robot robot : robots) {
                    int x = (int) (Math.random() * 100);
                    int y = (int) (Math.random() * 100);
                    robot.setCoordX(x);
                    robot.setCoordY(y);
                }
                System.out.println("New coordinates: " + robots);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
