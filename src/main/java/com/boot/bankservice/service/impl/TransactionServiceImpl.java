package com.boot.bankservice.service.impl;

import com.boot.bankservice.exception.DataProcessingException;
import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.Transaction;
import com.boot.bankservice.repository.TransactionRepository;
import com.boot.bankservice.service.AccountService;
import com.boot.bankservice.service.TransactionService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Transactional
    @Override
    public void completeTransaction(String accountNumberFrom,
                                    String accountNumberTo, Double amount) {
        Account accountFrom = accountService.getByAccountNumber(accountNumberFrom);
        Account accountTo = accountService.getByAccountNumber(accountNumberTo);
        Transaction outcome = new Transaction();
        outcome.setAccountFrom(accountFrom);
        outcome.setAccountTo(accountTo);
        outcome.setDate(LocalDateTime.now());
        outcome.setType(Transaction.Type.OUTCOMING);
        outcome.setAmount(new BigDecimal(amount));
        accountFrom.setBalance(accountFrom.getBalance().subtract(new BigDecimal(amount)));
        if (accountFrom.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new DataProcessingException("Balance can't be less than 0 ");
        }
        transactionRepository.save(outcome);
        accountService.update(accountFrom);
        Transaction income = new Transaction();
        income.setAccountFrom(accountFrom);
        income.setAccountTo(accountTo);
        income.setDate(outcome.getDate());
        income.setAmount(new BigDecimal(amount));
        income.setType(Transaction.Type.INCOMING);
        transactionRepository.save(income);
        accountTo.setBalance(accountTo.getBalance().add(income.getAmount()));
        accountService.update(accountTo);
    }

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return transactionRepository.getAllByAccount(pageable, account);
    }
}
