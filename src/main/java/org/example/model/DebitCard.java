package org.example.model;

import org.example.dto.BalanceInfo;

public class DebitCard extends BankCard {

    public DebitCard() {
        super();
    }

    public DebitCard(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void addBalance(double value) {
        if (value > 0) this.balance += value;
    }

    @Override
    public BalanceInfo getBalanceInfo() {
        return new BalanceInfo(this.balance);
    }
}
