package org.example.controller;

import org.example.model.Account;
import org.example.model.Transaction;
import org.example.service.AccountService;
import org.example.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferFunds(@RequestBody TransferRequest transferRequest) {
        try {
            accountService.transferFunds(transferRequest.getFromAccount(), transferRequest.getToAccount(), transferRequest.getAmount());
            return new ResponseEntity<>("Funds transferred successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/credit")
    public ResponseEntity<String> creditAmount(@RequestBody CreditRequest creditRequest) {
        try {
            accountService.creditAmount(creditRequest.getAccountNumber(), creditRequest.getAmount());
            return new ResponseEntity<>("Amount credited successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdrawAmount(@RequestBody WithdrawRequest withdrawRequest) {
        try {
            accountService.withdrawAmount(withdrawRequest.getAccountNumber(), withdrawRequest.getAmount());
            return new ResponseEntity<>("Amount withdrawn successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Double> getAccountBalance(@PathVariable String accountNumber) {
        try {
            Double balance = accountService.getAccountBalance(accountNumber);
            return new ResponseEntity<>(balance, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/history/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionHistory(accountNumber);
        if (transactions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
