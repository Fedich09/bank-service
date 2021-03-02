package com.boot.bankservice.service;

import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction completeTransaction(String accountFrom, String accountTo, Double amount);

    List<Transaction> getAllByAccount(int page, int size, Account account);
}
