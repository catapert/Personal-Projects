package Pert.Catalin.Lab11.Ex1;

import javax.swing.*;
import java.awt.*;

public class Interface extends JFrame implements Observer {
    JTextField text = new JTextField();

    public Interface() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 60);
        this.setLayout(new GridLayout(1, 3));
        this.text = new JTextField("");
        this.add(text);
        this.setVisible(true);
    }

    @Override
    public void update(Object event) {
        text.setText(event.toString());
    }
}
