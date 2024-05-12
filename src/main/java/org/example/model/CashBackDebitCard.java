package org.example.model;

import org.example.dto.BonusBalanceInfo;

public class CashBackDebitCard extends DebitCard {
    protected double bonuses;

    public CashBackDebitCard() {
        super();
    }

    public CashBackDebitCard(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean removeBalance(double value) {
        if (value > 0 && (this.balance >= value)) {
            this.balance -= value;
            if (value >= 5000 && bonuses >= 100) {
                this.balance += 0.05 * value;
                this.bonuses -= 100;
            }
            this.bonuses += 0.1 * value;
            return true;
        } else {
            return false;
        }
    }

    public double getBonuses() {
        return bonuses;
    }

    @Override
    public BonusBalanceInfo getBalanceInfo() {
        BonusBalanceInfo balanceInfo = new BonusBalanceInfo();
        balanceInfo.setBalance(balance);
        balanceInfo.setBonusBalance(bonuses);
        return balanceInfo;
    }
}
