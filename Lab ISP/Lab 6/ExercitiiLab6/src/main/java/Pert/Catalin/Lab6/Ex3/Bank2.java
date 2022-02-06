package Pert.Catalin.Lab6.Ex3;

import Pert.Catalin.Lab6.Ex1.BankAccount;

import java.util.TreeSet;

public class Bank2 {
    private TreeSet<BankAccount> bankAccounts;

    public Bank2() {
        this.bankAccounts = new TreeSet<>();
    }

    public void addAccount(String owner, double balance) {
        this.bankAccounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts() {
        this.bankAccounts.forEach(System.out::println);
    }

    public void printAccounts(double minBalance, double maxBalance) {
        this.bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() >= minBalance && bankAccount.getBalance() <= maxBalance)
                .forEach(System.out::println);
    }

    public BankAccount getBankAccount(String owner) {
        return this.bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }
}