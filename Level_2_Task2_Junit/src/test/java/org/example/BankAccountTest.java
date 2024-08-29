package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.01);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.contains("Deposited: 100.0"));
    }

    @Test
    public void testWithdraw() {
        account.deposit(200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.01);
        List<String> history = account.getTransactionHistory();
        assertTrue(history.contains("Withdrew: 50.0"));
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        account.withdraw(150.0);
        assertEquals(100.0, account.getBalance(), 0.01); // Balance should remain unchanged
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(200.0);
        account.withdraw(100.0);
        List<String> history = account.getTransactionHistory();
        assertEquals(2, history.size());
        assertTrue(history.contains("Deposited: 200.0"));
        assertTrue(history.contains("Withdrew: 100.0"));
    }

}
