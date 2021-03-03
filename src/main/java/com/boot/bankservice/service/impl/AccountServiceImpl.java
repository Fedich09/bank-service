package com.boot.bankservice.service.impl;

import com.boot.bankservice.exception.DataProcessingException;
import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.User;
import com.boot.bankservice.repository.AccountRepository;
import com.boot.bankservice.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account get(Long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new DataProcessingException("Can't get by id " + id));
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

    @Override
    public List<Account> getAllAccountByUser(User user) {
        return accountRepository.getAllByUser(user);
    }
}

