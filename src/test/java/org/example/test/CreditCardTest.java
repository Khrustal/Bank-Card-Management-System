package org.example.test;

import org.example.dto.CreditBalanceInfo;
import org.example.model.CreditCard;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CreditCardTest {
    @Test
    public void testAddBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        creditCard.addBalance(200.0);
        assertEquals(300.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testAddBalanceWithNegativeValue() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        creditCard.addBalance(-200.0);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetBalanceInfo() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        CreditBalanceInfo balanceInfo = creditCard.getBalanceInfo();
        assertEquals(100.0, balanceInfo.getBalance());
        assertEquals(500.0, balanceInfo.getCreditBalance());
        assertEquals(500.0, balanceInfo.getCreditLimit());
        assertEquals(600.0, balanceInfo.getTotalAvailable());
    }

    @Test
    public void testRemoveBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(50.0);
        assertTrue(result);
        assertEquals(50.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(700.0);
        assertFalse(result);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetCreditBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testGetCreditLimit() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        assertEquals(500.0, creditCard.getCreditLimit());
    }

    @Test
    public void testRemoveBalanceUsingCreditBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(200.0);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(400.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableTotalBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(700.0);
        assertFalse(result);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }

    @Test
    public void testRestoreBalanceUsingCreditBalance() {
        CreditCard creditCard = new CreditCard(100.0, 500.0);
        boolean result = creditCard.removeBalance(600.0);
        assertTrue(result);
        assertEquals(0.0, creditCard.getBalance());
        assertEquals(0.0, creditCard.getCreditBalance());
        creditCard.addBalance(600);
        assertEquals(100.0, creditCard.getBalance());
        assertEquals(500.0, creditCard.getCreditBalance());
    }
}
