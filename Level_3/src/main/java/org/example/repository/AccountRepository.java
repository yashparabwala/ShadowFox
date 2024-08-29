package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.model.Account;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
}