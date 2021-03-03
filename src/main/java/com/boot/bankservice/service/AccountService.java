package com.boot.bankservice.service;

import com.boot.bankservice.model.Account;
import com.boot.bankservice.model.User;
import java.util.List;

public interface AccountService {
    Account save(Account account);

    Account get(Long id);

    Account update(Account account);

    void delete(Account account);

    Account getByAccountNumber(String number);

    List<Account> getAllAccountByUser(User user);
}
