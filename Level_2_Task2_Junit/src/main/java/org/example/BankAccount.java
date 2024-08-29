package org.example;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private List<String> transactionHistory;

    public BankAccount() {
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }
}

