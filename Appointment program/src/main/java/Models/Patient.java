package Models;

import java.io.Serializable;
import java.util.Objects;

public class Patient implements Serializable {
    public String name;
    public char gender;
    public int age;

    public Patient(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.gender = Character.toUpperCase(this.gender);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
        this.gender = Character.toUpperCase(this.gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return gender == patient.gender && age == patient.age && name.equals(patient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name: " + name +
                ", gender: " + gender +
                ", age: " + age +
                '}';
    }
}
