package org.example.model;

import org.example.dto.CreditBonusBalanceInfo;

public class DiscountCreditCard extends CreditCard {
    protected double bonuses;

    public DiscountCreditCard(double initialBalance, double creditLimit) {
        super(initialBalance, creditLimit);
    }

    @Override
    public boolean removeBalance(double value) {
        if (value > 0) {
            if (bonuses >= 100 && (0.95 * value <= (this.balance + this.creditBalance))) {
                this.balance -= 0.95 * value;
                this.bonuses -= 100;
                if (this.balance < 0) {
                    this.creditBalance += this.balance;
                    this.balance = 0d;
                }
                this.bonuses += 0.1 * value;
                return true;
            } else if (value <= (this.balance + this.creditBalance)) {
                this.balance -= value;
                if (this.balance < 0) {
                    this.creditBalance += this.balance;
                    this.balance = 0d;
                }
                this.bonuses += 0.1 * value;
                return true;
            }
        }
        return false;
    }

    @Override
    public CreditBonusBalanceInfo getBalanceInfo() {
        CreditBonusBalanceInfo balanceInfo = new CreditBonusBalanceInfo();
        balanceInfo.setBalance(balance);
        balanceInfo.setCreditBalance(creditBalance);
        balanceInfo.setCreditLimit(creditLimit);
        balanceInfo.setTotalAvailable(balance + creditBalance);
        balanceInfo.setBonusBalance(bonuses);
        return balanceInfo;
    }

    public double getBonuses() {
        return bonuses;
    }
}
