package com.boot.bankservice.service;

import com.boot.bankservice.model.Account;
import java.util.Optional;

public interface AccountService {
    Account add(Account account);

    Optional<Account> get(Long id);

    Account update(Account account);

    void delete(Account account);

    Account getByAccountNumber(String number);
}
