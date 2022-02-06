package Pert.Catalin.Lab6.Ex1;

import java.util.Objects;

public class BankAccount implements Comparable<BankAccount> {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount < balance) {
            this.balance = this.balance - amount;
        } else
            System.out.println("Insufficient funds");
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0 && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, balance);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount(" + "Owner: " + owner +
                " , Balance: " + balance + ')';
    }

    @Override
    public int compareTo(BankAccount o) {
        return Double.compare(this.balance, o.balance);
    }


}
