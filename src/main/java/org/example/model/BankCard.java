package org.example.model;

import org.example.dto.BalanceInfo;

public abstract class BankCard {
    protected double balance;

    protected BankCard() {

    }

    protected BankCard(double initialBalance) {
        if (initialBalance > 0) this.balance = initialBalance;
    }

    public abstract void addBalance(double value);

    public boolean removeBalance(double value) {
        if (value > 0 && (this.balance >= value)) {
            this.balance -= value;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public abstract BalanceInfo getBalanceInfo();
}
