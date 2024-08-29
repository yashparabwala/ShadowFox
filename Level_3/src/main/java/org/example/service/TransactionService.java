package org.example.service;

import org.example.model.Transaction;
import org.example.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
    public List<Transaction> getTransactionHistory(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}


