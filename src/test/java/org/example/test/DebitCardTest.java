package org.example.test;

import org.example.dto.BalanceInfo;
import org.example.model.DebitCard;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class DebitCardTest {
    @Test
    public void testAddBalance() {
        DebitCard debitCard = new DebitCard(100.0);
        debitCard.addBalance(50.0);
        assertEquals(150.0, debitCard.getBalance());
    }

    @Test
    public void testAddBalanceWithNegativeValue() {
        DebitCard debitCard = new DebitCard(100.0);
        debitCard.addBalance(-50.0);
        assertEquals(100.0, debitCard.getBalance());
    }

    @Test
    public void testGetBalanceInfo() {
        DebitCard debitCard = new DebitCard(100.0);
        BalanceInfo balanceInfo = debitCard.getBalanceInfo();
        assertNotNull(balanceInfo);
        assertEquals(100.0, balanceInfo.getBalance());
    }

    @Test
    public void testRemoveBalance() {
        DebitCard debitCard = new DebitCard(100.0);
        boolean result = debitCard.removeBalance(50.0);
        assertTrue(result);
        assertEquals(50.0, debitCard.getBalance());
    }

    @Test
    public void testRemoveBalanceExceedingAvailableBalance() {
        DebitCard debitCard = new DebitCard(100.0);
        boolean result = debitCard.removeBalance(150.0);
        assertFalse(result);
        assertEquals(100.0, debitCard.getBalance());
    }
}
