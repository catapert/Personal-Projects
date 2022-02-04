package Models;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Appointment implements Serializable {
    public Patient patient;
    public Doctor doctor;
    public int appHour;
    public int appMinute;
    public int appDay;
    public int appMonth;
    public GregorianCalendar calendar = new GregorianCalendar();
    boolean isList = false;

    public Appointment(Patient patient, Doctor doctor, int appHour, int appMinute, int appDay, int appMonth) {
        this.patient = patient;
        this.doctor = doctor;
        this.appHour = appHour;
        this.appMinute = appMinute;
        this.appDay = appDay;
        this.appMonth = appMonth;
        calendar.set(2021,this.appMonth,this.appDay,this.appHour,this.appMinute);
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public GregorianCalendar getCalendar() {
        return calendar;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setAppHour(int appHour) {
        this.appHour = appHour;
        calendar.set(2021,this.appMonth,this.appDay,this.appHour,this.appMinute);
    }

    public void setAppMinute(int appMinute) {
        this.appMinute = appMinute;
        calendar.set(2021,this.appMonth,this.appDay,this.appHour,this.appMinute);
    }

    public void setAppDay(int appDay) {
        this.appDay = appDay;
        calendar.set(2021,this.appMonth,this.appDay,this.appHour,this.appMinute);
    }

    public void setAppMonth(int appMonth) {
        this.appMonth = appMonth;
        calendar.set(2021,this.appMonth,this.appDay,this.appHour,this.appMinute);
    }

    public boolean isList() {
        return isList;
    }

    public void setList(boolean list) {
        isList = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appHour == that.appHour && appMinute == that.appMinute && appDay == that.appDay && appMonth == that.appMonth && isList == that.isList && patient.equals(that.patient) && doctor.equals(that.doctor) && calendar.equals(that.calendar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctor, appHour, appMinute, appDay, appMonth, calendar, isList);
    }

    @Override
    public String toString() {
        if(isList){
            return "<html>Appointment{" +
                    "patient: " + patient +
                    ", <br>\ndoctor: " + doctor +
                    ", <br>\ndate: " + calendar.getTime() +
                    "}\n</span></html>";
        }
        else{
            return "Appointment{" +
                    "patient: " + patient +
                    ", \ndoctor: " + doctor +
                    ", \ndate: " + calendar.getTime() +
                    "}\n";
        }

    }
}
