import Models.Account;
import Models.Appointment;
import Models.Doctor;
import Models.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Tests {
    private static final List<Doctor> doctors = new ArrayList<>();
    private static final List<Account> accounts = new ArrayList<>();
    private static final List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        doctors.add(new Doctor("James", 'm', 45, "Neurology", 8, 0, 16, 0));
        doctors.add(new Doctor("Ana", 'f', 37, "Pathology", 10, 30, 18, 30));
        doctors.add(new Doctor("Derek", 'm', 54, "Dermatology", 12, 0, 20, 0));
        for (int i = 0; i < doctors.size(); i++) {
            String user = "dr" + doctors.get(i).getName();
            String pass = "password" + i;
            accounts.add(new Account(user, pass, doctors.get(i)));
            System.out.println(accounts);
        }
        if (accounts.stream().anyMatch(account -> account.getUsername().equals("drAna"))
                && accounts.stream().anyMatch(account -> account.getPassword().equals("password1"))) {
            System.out.println(accounts.stream().filter(account -> account.getUsername().equals("drAna")).findFirst().orElse(null));
        }

        String[] names = {"Joe", "Tom", "Amanda", "Rebecca", "Tim", "Arnold"};
        System.out.println(names[1]);
        String[] DrNames = new String[doctors.size()];
        String[] DrNames2 = new String[doctors.size()];
        for (int i = 0; i < doctors.size(); i++) {
            DrNames[i] = "Dr." + doctors.get(i).getName();
            DrNames2[i] = doctors.get(i).getName();
        }
        String nameOfDoctor = DrNames[1];
        Doctor dr = doctors.stream().filter(doctor -> doctor.getName().equals(DrNames2[2])).findFirst().orElse(null);
        System.out.println(dr);

        GregorianCalendar C = new GregorianCalendar();
        C.set(2021, 7, 15, 20, 30);
        System.out.println(C.get(Calendar.MONTH));

        /*
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/java/TextFiles/AppointmentsDrAna.txt"))) {
            System.out.println((Appointment) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String drName = DrNames[1].substring(2);
        System.out.println(drName);
         */
        for (int i = 0; i < 6; i++) {
            String[] Pnames = {"Joe", "Tom", "Amanda", "Rebecca", "Tim", "Arnold"};
            char[] genders = {'m', 'm', 'f', 'f', 'm', 'm'};
            patients.add(new Patient(Pnames[i], genders[i], 25 + 2 * i));
        }
/*
        Appointment A1 = new Appointment(patients.get(0), doctors.get(1), 13, 15, 10, 11);
        Appointment A2 = new Appointment(patients.get(1), doctors.get(1), 13, 15, 9, 11);
        ArrayList<Appointment> woi = new ArrayList<>();
        try {
            FileOutputStream fop = new FileOutputStream("src/main/java/TextFiles/AppointmentsDrAna.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fop);
            woi.add(A1);
            woi.add(A2);
            oos.writeObject(woi);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("src/main/java/TextFiles/AppointmentsDrAna.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Appointment> woii = new ArrayList<>();
            woii = (ArrayList<Appointment>) ois.readObject();

            for (int i = 0; i < woii.size(); i++) {
                System.out.println(woii.get(i).toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

 */

    }
}
