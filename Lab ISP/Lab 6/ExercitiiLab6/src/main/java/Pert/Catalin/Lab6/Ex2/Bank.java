package Pert.Catalin.Lab6.Ex2;

import Pert.Catalin.Lab6.Ex1.BankAccount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<BankAccount> bankAccounts;

    public Bank() {
        this.bankAccounts = new ArrayList<>();
    }

    public void addAccount(String owner, double balance) {
        this.bankAccounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts() {
        bankAccounts.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        for (int i = 0; i < bankAccounts.size(); i++) {
            System.out.println(this.bankAccounts.get(i));
        }
    }

    public void printAccounts(double minBalance, double maxBalance) {
        bankAccounts.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (this.bankAccounts.get(i).getBalance() >= minBalance &&
                    this.bankAccounts.get(i).getBalance() <= maxBalance) {
                System.out.println(this.bankAccounts.get(i).toString());
            }
        }
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

}
