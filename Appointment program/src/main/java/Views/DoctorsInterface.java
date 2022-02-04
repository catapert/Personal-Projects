package Views;

import javax.swing.*;

public class DoctorsInterface {
    private JTextArea PersonalInfoArea;
    public JPanel DoctorsPanel;
    private JLabel PersonalInfoLabel;
    private JList AppointmentsList;
    private JComboBox AppointmentDayBox;
    private JLabel DayLabel;
    private JComboBox AppointmentMonthBox;
    private JLabel MonthLabel;
    private JButton AppointmentsButton;
    private JButton LogOutButton;
    private JList AppointmentList;
    private JButton DeleteAppButton;

    public JTextArea getPersonalInfoArea() {
        return PersonalInfoArea;
    }

    public JComboBox getAppointmentDayBox() {
        return AppointmentDayBox;
    }

    public JComboBox getAppointmentMonthBox() {
        return AppointmentMonthBox;
    }

    public JButton getAppointmentsButton() {
        return AppointmentsButton;
    }


    public JButton getLogOutButton() {
        return LogOutButton;
    }

    public JList getAppointmentList() {
        return AppointmentList;
    }

    public JButton getDeleteAppButton() {
        return DeleteAppButton;
    }
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("DoctorsInterface");
        frame.setContentPane(new DoctorsInterface().DoctorsPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

 */

}
