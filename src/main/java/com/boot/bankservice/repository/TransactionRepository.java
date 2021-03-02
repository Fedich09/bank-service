package com.boot.bankservice.repository;

import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("FROM transaction t JOIN FETCH t.accountFrom  JOIN FETCH t.accountTo "
            + "WHERE t.accountFrom = :account OR t.accountTo = :account ")
    List<Transaction> getAllByAccount(Pageable pageable, @Param("account") Account account);
}
