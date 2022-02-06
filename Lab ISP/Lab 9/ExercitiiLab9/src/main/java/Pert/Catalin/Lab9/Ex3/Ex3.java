package Pert.Catalin.Lab9.Ex3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex3 {
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel PanelEx3;

    public Ex3() {

        textField1.setText("src/main/java/Pert/Catalin/Lab9/Ex3/Text Ex3.txt");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new File(textField1.getText()));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                StringBuilder textToDisplay = new StringBuilder();
                while (scanner.hasNextLine())
                    textToDisplay.append(scanner.nextLine()).append('\n');
                final String displayedText = textToDisplay.toString();
                textArea1.setText(displayedText);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ex3");
        frame.setContentPane(new Ex3().PanelEx3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
