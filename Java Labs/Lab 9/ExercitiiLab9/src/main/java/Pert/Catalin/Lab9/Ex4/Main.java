package Pert.Catalin.Lab9.Ex4;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Ex4 ex4 = new Ex4();
        JFrame frame = new JFrame("Ex4");
        frame.setContentPane(ex4.getPanelEx4());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
