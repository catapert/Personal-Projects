package Pert.Catalin.Lab6.Ex3;

public class Main {
    public static void main(String[] args) {
        Bank2 bank2 = new Bank2();
        bank2.addAccount("Dana", 180);
        bank2.addAccount("Dan", 280);
        bank2.addAccount("Sorana", 150);
        bank2.addAccount("Sorin", 250);
        bank2.addAccount("Bob", 35);
        System.out.println(bank2.getBankAccount("Bob"));
    }
}
