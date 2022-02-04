package Views;

import javax.swing.*;

public class LoginInterface {
    public JPanel LoginPanel;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JCheckBox patientCheckBox;
    private JButton loginButton;
    private JPasswordField passwordField;

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JCheckBox getPatientCheckBox() {
        return patientCheckBox;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginInterface");
        frame.setContentPane(new LoginInterface().LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

 */
}
