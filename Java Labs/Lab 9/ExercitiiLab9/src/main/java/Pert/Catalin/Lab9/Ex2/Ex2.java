package Pert.Catalin.Lab9.Ex2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex2 {
    private JButton button1;
    private JTextField textField1;
    private JPanel PanelEx2;

    public Ex2() {
        button1.addActionListener(new ActionListener() {
            int clicks = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++;
                textField1.setText("Clicks counted : " + clicks);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Counter");
        frame.setContentPane(new Ex2().PanelEx2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
