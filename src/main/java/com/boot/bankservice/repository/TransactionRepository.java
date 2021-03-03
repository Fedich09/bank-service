package com.boot.bankservice.repository;

import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("FROM transaction t WHERE t.accountFrom = :account OR t.accountTo = :account ")
    List<Transaction> getAllByAccount(Pageable pageable, Account account);
}
