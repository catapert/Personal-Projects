package Pert.Catalin.Lab6.Ex2;

import Pert.Catalin.Lab6.Ex1.BankAccount;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount("Dana", 180);
        bank.addAccount("Dan", 280);
        bank.addAccount("Sorana", 150);
        bank.addAccount("Sorin", 250);
        bank.addAccount("Bob", 35);
        bank.printAccounts();
        System.out.println('\n');
        bank.printAccounts(150, 270);
        System.out.println('\n');
        List<BankAccount> bankAccounts = bank.getBankAccounts();
        bankAccounts.sort(Comparator.comparing(BankAccount::getOwner));
        bankAccounts.forEach(System.out::println);
    }
}
