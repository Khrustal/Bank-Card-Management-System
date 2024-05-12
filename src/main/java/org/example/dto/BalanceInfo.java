package org.example.dto;

public class BalanceInfo {
    private double balance;

    public BalanceInfo() {}
    public BalanceInfo(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
