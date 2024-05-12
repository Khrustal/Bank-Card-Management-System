package org.example.model;

import org.example.dto.CreditBalanceInfo;

public class CreditCard extends BankCard {
    protected double creditBalance;
    protected double creditLimit;

    public CreditCard(double initialBalance, double creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
    }

    @Override
    public void addBalance(double value) {
        if (value > 0) {
            if (creditBalance < creditLimit) {
                this.creditBalance += value;
                if (creditBalance > creditLimit) {
                    this.balance += creditBalance - creditLimit;
                    creditBalance = creditLimit;
                }
            } else {
                this.balance += value;
            }
        }
    }

    @Override
    public boolean removeBalance(double value) {
        if (value > 0 && (value <= (this.balance + this.creditBalance))) {
            this.balance -= value;
            if (this.balance < 0) {
                this.creditBalance += this.balance;
                this.balance = 0d;
            }
            return true;
        }
        return false;
    }

    @Override
    public CreditBalanceInfo getBalanceInfo() {
        CreditBalanceInfo balanceInfo = new CreditBalanceInfo();
        balanceInfo.setBalance(balance);
        balanceInfo.setCreditBalance(creditBalance);
        balanceInfo.setCreditLimit(creditLimit);
        balanceInfo.setTotalAvailable(balance + creditBalance);
        return balanceInfo;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
