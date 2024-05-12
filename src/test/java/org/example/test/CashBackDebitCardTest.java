package org.example.test;

import org.example.dto.BonusBalanceInfo;
import org.example.model.CashBackDebitCard;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CashBackDebitCardTest {
    @Test
    public void testAddBalance() {
        CashBackDebitCard debitCard = new CashBackDebitCard(100.0);
        debitCard.addBalance(50.0);
        assertEquals(150.0, debitCard.getBalance());
    }

    @Test
    public void testAddBalanceWithNegativeValue() {
        CashBackDebitCard debitCard = new CashBackDebitCard(100.0);
        debitCard.addBalance(-50.0);
        assertEquals(100.0, debitCard.getBalance());
    }

    @Test
    public void testGetBalanceInfo() {
        CashBackDebitCard debitCard = new CashBackDebitCard(100.0);
        BonusBalanceInfo balanceInfo = debitCard.getBalanceInfo();
        assertNotNull(balanceInfo);
        assertEquals(100.0, balanceInfo.getBalance());
        assertEquals(0.0, balanceInfo.getBonusBalance());
    }

    @Test
    public void testRemoveBalance() {
        CashBackDebitCard debitCard = new CashBackDebitCard(100.0);
        boolean result = debitCard.removeBalance(50.0);
        assertTrue(result);
        assertEquals(50.0, debitCard.getBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableBalance() {
        CashBackDebitCard debitCard = new CashBackDebitCard(100.0);
        boolean result = debitCard.removeBalance(150.0);
        assertFalse(result);
        assertEquals(100.0, debitCard.getBalance());
    }

    @Test
    public void testCashBack() {
        CashBackDebitCard debitCard = new CashBackDebitCard(20000.0);
        boolean result = debitCard.removeBalance(10000.0);
        assertTrue(result);
        assertEquals(10000.0, debitCard.getBalance());
        assertEquals(1000.0, debitCard.getBonuses());
        result = debitCard.removeBalance(10000.0);
        assertTrue(result);
        assertEquals(500.0, debitCard.getBalance());
        assertEquals(1900.0, debitCard.getBonuses());
    }
}
