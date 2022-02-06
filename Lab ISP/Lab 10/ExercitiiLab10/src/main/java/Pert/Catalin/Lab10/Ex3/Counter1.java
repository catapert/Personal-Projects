package Pert.Catalin.Lab10.Ex3;

public class Counter1 extends Thread {
    public Counter1() {
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
