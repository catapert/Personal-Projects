package Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Doctor implements Serializable {
    public String name;
    public char gender;
    public int age;
    public String speciality;
    public GregorianCalendar startShift = new GregorianCalendar();
    public GregorianCalendar endShift = new GregorianCalendar();
    public int startHour;
    public int startMinute;
    public int endHour;
    public int endMinute;


    public Doctor(String name, char gender, int age, String speciality, int startHour, int startMinute, int endHour, int endMinute) {
        this.name = name;
        this.gender = gender;
        this.gender = Character.toUpperCase(this.gender);
        this.age = age;
        this.speciality = speciality;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.startShift.set(Calendar.HOUR_OF_DAY, this.startHour);
        this.startShift.set(Calendar.MINUTE, this.startMinute);
        this.endShift.set(Calendar.HOUR_OF_DAY, this.endHour);
        this.endShift.set(Calendar.MINUTE, this.endMinute);
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public GregorianCalendar getStartShift() {
        return startShift;
    }

    public GregorianCalendar getEndShift() {
        return endShift;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
        this.gender = Character.toUpperCase(this.gender);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
        this.startShift.set(Calendar.HOUR_OF_DAY, this.startHour);
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
        this.startShift.set(Calendar.MINUTE, this.startMinute);
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
        this.endShift.set(Calendar.HOUR_OF_DAY, this.endHour);
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
        this.endShift.set(Calendar.MINUTE, this.endMinute);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return gender == doctor.gender && age == doctor.age && startHour == doctor.startHour && startMinute == doctor.startMinute && endHour == doctor.endHour && endMinute == doctor.endMinute && name.equals(doctor.name) && speciality.equals(doctor.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, speciality, startShift, endShift);
    }

    @Override
    public String toString() {
        return "Dr: " + name +
                ", gender: " + gender +
                " , age: " + age +
                ", speciality: " + speciality +
                ", \nstartShift: " + startShift.get(Calendar.HOUR_OF_DAY) + ":" + startShift.get(Calendar.MINUTE) +
                ", endShift: " + endShift.get(Calendar.HOUR_OF_DAY) + ":" + endShift.get(Calendar.MINUTE);
    }
}
