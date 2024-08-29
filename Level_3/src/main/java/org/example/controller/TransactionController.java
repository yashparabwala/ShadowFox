package org.example.controller;


import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.model.Transaction;

import java.util.List;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/history/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionHistory(accountNumber);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
