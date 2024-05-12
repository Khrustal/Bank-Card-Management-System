package org.example.dto;

public class CreditBalanceInfo extends BalanceInfo {
    private double creditBalance;
    private double creditLimit;

    private double totalAvailable;

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(double totalAvailable) {
        this.totalAvailable = totalAvailable;
    }
}
