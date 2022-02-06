package Pert.Catalin.Lab6.Ex1;

public class Main {
    public static void main(String[] args) {
        BankAccount Nr1 = new BankAccount("A", 100);
        BankAccount Nr2 = new BankAccount("A", 150);
        BankAccount Nr3 = new BankAccount("A", 100);
        BankAccount Nr4 = new BankAccount("B", 100);
        System.out.println("Nr1 = Nr2  " + Nr1.equals(Nr2));
        System.out.println("Nr1 = Nr3  " + Nr1.equals(Nr3));
        System.out.println("Nr2 = Nr4  " + Nr2.equals(Nr4));
    }
}
