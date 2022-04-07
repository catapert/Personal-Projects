package Pert.Catalin.Lab10.Ex3;

public class Counter2 {
    public Counter2() {
    }

    public void run() {
        for (int i = 101; i <= 200; i++) {
            System.out.println(i );
            try {
                Thread.sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
