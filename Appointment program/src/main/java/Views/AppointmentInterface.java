package Views;

import javax.swing.*;

public class AppointmentInterface {
    private JList DoctorsList;
    private JButton DoctorInfoButton;
    public JPanel AppointmentPanel;
    private JLabel MonthLabel;
    private JLabel DayLabel;
    private JTextArea DoctorsInfoArea;
    private JLabel HourLabel;
    private JLabel MinuteLabel;
    private JButton MakeAppointmentButton;
    private JTextArea AppointmentInfoArea;
    private JComboBox MonthBox;
    private JComboBox DayBox;
    private JComboBox HourBox;
    private JComboBox MinuteBox;
    private JTextField PatientNameField;
    private JLabel PatientNameLabel;
    private JLabel PatientAgeLabel;
    private JTextField PatientAgeField;
    private JComboBox PatientGenderBox;
    private JLabel PatientGenderLabel;
    private JButton BackButton;

    public JList getDoctorsList() {
        return DoctorsList;
    }

    public JButton getDoctorInfoButton() {
        return DoctorInfoButton;
    }

    public JTextArea getDoctorsInfoArea() {
        return DoctorsInfoArea;
    }

    public JButton getMakeAppointmentButton() {
        return MakeAppointmentButton;
    }

    public JTextArea getAppointmentInfoArea() {
        return AppointmentInfoArea;
    }

    public JComboBox getMonthBox() {
        return MonthBox;
    }

    public JComboBox getDayBox() {
        return DayBox;
    }

    public JComboBox getHourBox() {
        return HourBox;
    }

    public JComboBox getMinuteBox() {
        return MinuteBox;
    }

    public JTextField getPatientNameField() {
        return PatientNameField;
    }

    public JTextField getPatientAgeField() {
        return PatientAgeField;
    }

    public JComboBox getPatientGenderBox() {
        return PatientGenderBox;
    }

    public JButton getBackButton() {
        return BackButton;
    }
    /*
    public static void main(String[] args) {
        JFrame frame = new JFrame("AppointmentInterface");
        frame.setContentPane(new AppointmentInterface().AppointmentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

 */
}
