package org.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.example.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNumber(String accountNumber);
}