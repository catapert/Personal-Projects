import Models.Account;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;
import Views.AppointmentInterface;
import Views.DoctorsInterface;
import Views.LoginInterface;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ConstantConditions")
public class Controller {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Account> accounts = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appWrite = new ArrayList<>();


    public static void main(String[] args) {
        //Create some doctors
        doctors.add(new Doctor("James", 'm', 45, "Neurology", 8, 0, 16, 0));
        doctors.add(new Doctor("Ana", 'f', 37, "Pathology", 10, 30, 18, 30));
        doctors.add(new Doctor("Derek", 'm', 54, "Dermatology", 12, 0, 20, 0));

        //Create accounts for doctors
        for (int i = 0; i < doctors.size(); i++) {
            String user = "dr" + doctors.get(i).getName();
            String pass = "password" + i;
            accounts.add(new Account(user, pass, doctors.get(i)));
        }

        //Create some patients
        for (int i = 0; i < 30; i++) {
            String[] names = {"Joe", "Tom", "Amanda", "Rebecca", "Tim", "Arnold","Vlad","Elena","Tina","Samantha",
                    "Joe2", "Tom2", "Amanda2", "Rebecca2", "Tim2", "Arnold2","Vlad2","Elena2","Tina2","Samantha2",
                    "Joe3", "Tom3", "Amanda3", "Rebecca3", "Tim3", "Arnold3","Vlad3","Elena3","Tina3","Samantha3"};
            char[] genders = {'m', 'm', 'f', 'f', 'm', 'm','m','f','f','f',
                    'm', 'm', 'f', 'f', 'm', 'm','m','f','f','f',
                    'm', 'm', 'f', 'f', 'm', 'm','m','f','f','f'};
            patients.add(new Patient(names[i], genders[i], 25 + 2 * i));
        }

        //Create Login Window
        JFrame frame = new JFrame("LoginInterface");
        LoginInterface loginInterface = new LoginInterface();
        frame.setContentPane(loginInterface.LoginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Action listener for Login button
        //Check if there are any account with the inserted username and password
        loginInterface.getLoginButton().addActionListener(e -> {
            if (accounts.stream().anyMatch(account -> account.getUsername().equals(loginInterface.getUsernameField().getText()))
                    && accounts.stream().anyMatch(account -> account.getPassword().equals(String.valueOf(loginInterface.getPasswordField().getPassword())))) {
                //Close Login window
                frame.dispose();

                //Open Doctor's window
                JFrame frame3 = new JFrame("DoctorsInterface");
                DoctorsInterface doctorsInterface = new DoctorsInterface();
                frame3.setContentPane(doctorsInterface.DoctorsPanel);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.pack();
                frame3.setVisible(true);
                for (int i = 0; i < 12; i++) {
                    doctorsInterface.getAppointmentMonthBox().addItem(i + 1);
                }
                int[] monthsWith30Days = {4, 6, 9, 11,};
                doctorsInterface.getAppointmentDayBox().addItem(0);

                //Action Listener for log out button
                doctorsInterface.getLogOutButton().addActionListener(e1 -> {
                    frame3.dispose();
                    loginInterface.getUsernameField().setText("");
                    loginInterface.getPasswordField().setText("");
                    loginInterface.getPatientCheckBox().setSelected(false);
                    frame.setVisible(true);
                });

                //Action listener to see how many days are in the selected month
                doctorsInterface.getAppointmentMonthBox().addActionListener(e1 -> {
                    if (Objects.equals(doctorsInterface.getAppointmentMonthBox().getSelectedItem(), monthsWith30Days)) {
                        doctorsInterface.getAppointmentDayBox().removeAllItems();
                        for (int i = 0; i <= 30; i++) {
                            doctorsInterface.getAppointmentDayBox().addItem(i);
                        }
                    } else if (Objects.equals(doctorsInterface.getAppointmentMonthBox().getSelectedItem(), 2)) {
                        doctorsInterface.getAppointmentDayBox().removeAllItems();
                        for (int i = 0; i <= 28; i++) {
                            doctorsInterface.getAppointmentDayBox().addItem(i);
                        }
                    } else {
                        doctorsInterface.getAppointmentDayBox().removeAllItems();
                        for (int i = 0; i <= 31; i++) {
                            doctorsInterface.getAppointmentDayBox().addItem(i);
                        }
                    }
                });
                String user = loginInterface.getUsernameField().getText();
                String drName = user.substring(2);
                Doctor dr = doctors.stream().filter(doctor -> doctor.getName().equals(drName)).findFirst().orElse(null);
                doctorsInterface.getPersonalInfoArea().setText(String.valueOf(dr));

                String filePath = "src/main/java/TextFiles/Appointments.txt";

                //Action listener for the button which shows created appointments
                doctorsInterface.getAppointmentsButton().addActionListener(e1 -> {
                    ArrayList<Appointment> appRead;
                    if (doctorsInterface.getAppointmentDayBox().getSelectedItem().equals(0)) {
                        try {
                            FileInputStream fis = new FileInputStream(filePath);
                            ObjectInputStream ois = new ObjectInputStream(fis);

                            appRead = (ArrayList<Appointment>) ois.readObject();
                            ArrayList<Appointment> goodApp = new ArrayList<>();

                            //Clear List
                            doctorsInterface.getAppointmentList().setListData(goodApp.toArray());

                            for (Appointment appointment : appRead) {
                                if (appointment.getDoctor().equals(dr) &&
                                        doctorsInterface.getAppointmentMonthBox().getSelectedItem().equals(appointment.getCalendar().get(Calendar.MONTH))
                                ) {
                                    appointment.setList(true);
                                    goodApp.add(appointment);
                                    doctorsInterface.getAppointmentList().setListData(goodApp.toArray());
                                }
                            }

                        } catch (IOException | ClassNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    } else {
                        try {
                            FileInputStream fis = new FileInputStream(filePath);
                            ObjectInputStream ois = new ObjectInputStream(fis);

                            appRead = (ArrayList<Appointment>) ois.readObject();
                            ArrayList<Appointment> goodApp = new ArrayList<>();

                            //Clear List
                            doctorsInterface.getAppointmentList().setListData(goodApp.toArray());

                            for (Appointment appointment : appRead) {
                                if (appointment.getDoctor().equals(dr) &&
                                        doctorsInterface.getAppointmentMonthBox().getSelectedItem().equals(appointment.getCalendar().get(Calendar.MONTH)) &&
                                        doctorsInterface.getAppointmentDayBox().getSelectedItem().equals(appointment.getCalendar().get(Calendar.DAY_OF_MONTH))) {
                                    appointment.setList(true);
                                    goodApp.add(appointment);
                                    doctorsInterface.getAppointmentList().setListData(goodApp.toArray());
                                }
                            }

                        } catch (IOException | ClassNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    }
                });

                //Action Listener for delete button
                doctorsInterface.getDeleteAppButton().addActionListener(e1 -> {
                    Appointment deletedApp = (Appointment) doctorsInterface.getAppointmentList().getSelectedValue();
                    deletedApp.setList(false);
                    ArrayList<Appointment> appRead;
                    try {
                        FileInputStream fis = new FileInputStream(filePath);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        appRead = (ArrayList<Appointment>) ois.readObject();
                        ArrayList<Appointment> goodApp = new ArrayList<>();

                        //delete appointment
                        appRead.removeIf(appointment -> appointment.equals(deletedApp));
                        appWrite=appRead;
                    } catch (IOException | ClassNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    //reinsert the appointments in text file
                    try {
                        FileOutputStream fop = new FileOutputStream(filePath);
                        ObjectOutputStream oos = new ObjectOutputStream(fop);
                        oos.writeObject(appWrite);

                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                });
            }

            //Check if the patient box has benn checked
            else if (loginInterface.getPatientCheckBox().isSelected()) {
                //Close Login window
                frame.dispose();

                //Open Appointment window
                JFrame frame2 = new JFrame("AppointmentInterface");
                AppointmentInterface appointmentInterface = new AppointmentInterface();
                frame2.setContentPane(appointmentInterface.AppointmentPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);


                String[] DrNames = new String[doctors.size()];
                String[] DrNames2 = new String[doctors.size()];
                for (int i = 0; i < doctors.size(); i++) {
                    DrNames[i] = "Dr. " + doctors.get(i).getName();
                    DrNames2[i] = doctors.get(i).getName();
                }
                appointmentInterface.getDoctorsList().setListData(DrNames);

                //Action Listener for back button
                appointmentInterface.getBackButton().addActionListener(e1 -> {
                    frame2.dispose();
                    loginInterface.getUsernameField().setText("");
                    loginInterface.getPasswordField().setText("");
                    loginInterface.getPatientCheckBox().setSelected(false);
                    frame.setVisible(true);
                });

                //Action listener for the button which show the Doctor's info
                appointmentInterface.getDoctorInfoButton().addActionListener(e1 -> {
                    int poz = appointmentInterface.getDoctorsList().getSelectedIndex();
                    appointmentInterface.getDoctorsInfoArea().setText(String.valueOf(doctors.stream().filter(doctor -> doctor.getName().equals(DrNames2[poz])).findFirst().orElse(null)));
                });

                List<Integer> months = new ArrayList<>();
                for (int i = 0; i < 12; i++) {
                    months.add(i + 1);
                    appointmentInterface.getMonthBox().addItem(months.get(i));
                }

                List<Integer> days = new ArrayList<>();
                int[] monthsWith30Days = {4, 6, 9, 11,};

                //Action listener to see how many days are in the selected month
                appointmentInterface.getMonthBox().addActionListener(e1 -> {
                    if (Objects.equals(appointmentInterface.getMonthBox().getSelectedItem(), monthsWith30Days)) {
                        appointmentInterface.getDayBox().removeAllItems();
                        days.clear();
                        for (int i = 0; i < 30; i++) {
                            days.add(i + 1);
                            appointmentInterface.getDayBox().addItem(days.get(i));
                        }
                    } else if (Objects.equals(appointmentInterface.getMonthBox().getSelectedItem(), 2)) {
                        appointmentInterface.getDayBox().removeAllItems();
                        days.clear();
                        for (int i = 0; i < 28; i++) {
                            days.add(i + 1);
                            appointmentInterface.getDayBox().addItem(days.get(i));
                        }
                    } else {
                        appointmentInterface.getDayBox().removeAllItems();
                        days.clear();
                        for (int i = 0; i < 31; i++) {
                            days.add(i + 1);
                            appointmentInterface.getDayBox().addItem(days.get(i));
                        }
                    }
                });
                List<Integer> hours = new ArrayList<>();
                for (int i = 0; i < 24; i++) {
                    hours.add(i);
                    appointmentInterface.getHourBox().addItem(hours.get(i));
                }
                List<Integer> minutes = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    minutes.add(i * 15);
                    appointmentInterface.getMinuteBox().addItem(minutes.get(i));
                }
                appointmentInterface.getPatientGenderBox().addItem('M');
                appointmentInterface.getPatientGenderBox().addItem('F');

                //Action listener for the button which saves the appointment
                appointmentInterface.getMakeAppointmentButton().addActionListener(e1 -> {

                    //Create some appointments
                    for (int i = 0; i < patients.size(); i++) {
                        String filePath = "src/main/java/TextFiles/Appointments.txt";
                        Appointment appointment = new Appointment(patients.get(i), doctors.get(i % doctors.size()), 13, 15, (i + 5)%30, i%12);
                        appWrite.add(appointment);
                        try {
                            FileOutputStream fop = new FileOutputStream(filePath);
                            ObjectOutputStream oos = new ObjectOutputStream(fop);
                            oos.writeObject(appWrite);

                        } catch (IOException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        }
                    }


                    String filePath = "src/main/java/TextFiles/Appointments.txt";
                    //Get past appointments
                    try {
                        FileInputStream fis = new FileInputStream(filePath);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        appWrite = (ArrayList<Appointment>) ois.readObject();

                    } catch (IOException | ClassNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    String PatientName = appointmentInterface.getPatientNameField().getText();
                    int PatientAge = Integer.parseInt(appointmentInterface.getPatientAgeField().getText());
                    char PatientGender = (char) appointmentInterface.getPatientGenderBox().getSelectedItem();
                    Patient patient = new Patient(PatientName, PatientGender, PatientAge);
                    int poz = appointmentInterface.getDoctorsList().getSelectedIndex();
                    Doctor dr = doctors.stream().filter(doctor -> doctor.getName().equals(DrNames2[poz])).findFirst().orElse(null);
                    Appointment app = new Appointment(patient, dr,
                            ((Integer) appointmentInterface.getHourBox().getSelectedItem()).intValue(),
                            ((Integer) appointmentInterface.getMinuteBox().getSelectedItem()).intValue(),
                            ((Integer) appointmentInterface.getDayBox().getSelectedItem()).intValue(),
                            ((Integer) appointmentInterface.getMonthBox().getSelectedItem()).intValue());
                    appointmentInterface.getAppointmentInfoArea().setText("Appointment done:\n" +
                            app);


                    appWrite.add(app);
                    try {
                        FileOutputStream fop = new FileOutputStream(filePath);
                        ObjectOutputStream oos = new ObjectOutputStream(fop);
                        oos.writeObject(appWrite);

                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                });
            }
        });
    }

}
