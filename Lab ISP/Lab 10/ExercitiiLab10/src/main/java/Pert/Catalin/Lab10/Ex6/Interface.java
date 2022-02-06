package Pert.Catalin.Lab10.Ex6;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame {
    JTextField text = new JTextField();
    volatile boolean started = false;
    volatile int seconds;
    volatile int minutes;

    public Interface(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 60);
        this.setLayout(new GridLayout(1, 3));
        JButton Start = new JButton("Start / Stop");
        JButton Reset = new JButton("Reset");
        Start.addActionListener(e -> {
            synchronized (Interface.this){
                notify();
                Interface.this.started = !Interface.this.started;
            }
        });
        Reset.addActionListener(e -> {
            Interface.this.seconds = 0;
            Interface.this.minutes = 0;
            text.setText(minutes + ":" + seconds);
        });
        this.add(text);
        this.add(Start);
        this.add(Reset);
        this.setVisible(true);
    }

}
