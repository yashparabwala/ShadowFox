package org.example.service;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    public Account createAccount(Account account) {
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    public Account findAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, Double amount) {
        Account fromAccount = findAccountByNumber(fromAccountNumber);
        Account toAccount = findAccountByNumber(toAccountNumber);

        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);

            // Record the transactions
            transactionService.saveTransaction(new Transaction("Transfer", amount, fromAccountNumber));
            transactionService.saveTransaction(new Transaction("Transfer", amount, toAccountNumber));
        } else {
            throw new RuntimeException("Insufficient funds or account not found");
        }
    }

    public void creditAmount(String accountNumber, Double amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);

            // Record the transaction
            transactionService.saveTransaction(new Transaction("Credit", amount, accountNumber));
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public void withdrawAmount(String accountNumber, Double amount) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            // Record the transaction
            transactionService.saveTransaction(new Transaction("Withdraw", amount, accountNumber));
        } else {
            throw new RuntimeException("Insufficient funds or account not found");
        }
    }

    public Double getAccountBalance(String accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            return account.getBalance();
        } else {
            throw new RuntimeException("Account not found");
        }
    }
}
