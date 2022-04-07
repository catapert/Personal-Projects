package Ex3;

public class Author {
    private String name;
    private String email;
    private char gender;
    public Author(String Name, String Email, char Gender){
        name=Name;
        email=Email;
        gender=Gender;
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

