package com.boot.bankservice.repository;

import com.boot.bankservice.model.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> getByAccountNumber(String number);
}
