package com.boot.bankservice.service.impl;

import com.boot.bankservice.exception.DataProcessingException;
import com.boot.bankservice.model.Account;
import com.boot.bankservice.repository.AccountRepository;
import com.boot.bankservice.service.AccountService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> get(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account getByAccountNumber(String number) {
        return accountRepository.getByAccountNumber(number).orElseThrow(() ->
                new DataProcessingException("Can't get by number " + number));
    }
}

