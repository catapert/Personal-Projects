package Pert.Catalin.Lab10.Ex6;

public class Chronometer extends Thread {
    Interface I1;

    public Chronometer(Interface i1) {
        I1 = i1;
    }

    @Override
    public void run() {
        while (true) {
            if (I1.started) {
                I1.seconds++;
                if (I1.seconds == 60) {
                    I1.seconds = 0;
                    I1.minutes++;
                }
                I1.text.setText(I1.minutes + ":" + I1.seconds);
            } else {
                synchronized (I1) {
                    try {
                        I1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
