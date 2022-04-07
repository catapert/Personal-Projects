package Pert.Catalin.Lab4.Ex2;

public class Author {
    private String name;
    private String email;
    private char gender;
    public Author(String Name, String Email, char Gender){
        this.name=Name;
        this.email=Email;
        this.gender=Gender;
    }
    public void setEmail(String NewEmail){
        this.email=NewEmail;
    }
    public String toString(String Name, String Email, char Gender){
        return Name + " (" + Gender + ") " + " at " + Email;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public char getGender(){
        return gender;
    }
}