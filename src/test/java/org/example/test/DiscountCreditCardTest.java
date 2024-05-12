package org.example.test;

import org.example.dto.CreditBonusBalanceInfo;
import org.example.model.DiscountCreditCard;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DiscountCreditCardTest {
    @Test
    public void testAddBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        creditCard.addBalance(200.0);
        assertEquals(300.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testAddBalanceWithNegativeValue() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        creditCard.addBalance(-200.0);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetBalanceInfo() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        CreditBonusBalanceInfo balanceInfo = creditCard.getBalanceInfo();
        assertEquals(100.0, balanceInfo.getBalance());
        assertEquals(500.0, balanceInfo.getCreditBalance());
        assertEquals(500.0, balanceInfo.getCreditLimit());
        assertEquals(600.0, balanceInfo.getTotalAvailable());
        assertEquals(0.0, balanceInfo.getBonusBalance());
    }

    @Test
    public void testRemoveBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(50.0);
        assertTrue(result);
        assertEquals(50.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(700.0);
        assertFalse(result);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetCreditBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetCreditLimit() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        assertEquals(500.0, creditCard.getCreditLimit());
    }

    @Test
    public void testRemoveBalanceUsingCreditBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(200.0);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(400.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableTotalBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(700.0);
        assertFalse(result);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRestoreBalanceUsingCreditBalance() {
        DiscountCreditCard creditCard = new DiscountCreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(600.0);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(0.0, creditCard.getCreditBalance());
        creditCard.addBalance(600);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testDiscount() {
        DiscountCreditCard creditCard = new DiscountCreditCard(1000.0, 1000.0);
        boolean result = creditCard.removeBalance(1000.0);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(1000.0, creditCard.getCreditBalance());
        assertEquals(100.0, creditCard.getBonuses());
        result = creditCard.removeBalance(1000);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(50.0, creditCard.getCreditBalance());
        assertEquals(100.0, creditCard.getBonuses());
    }
}
