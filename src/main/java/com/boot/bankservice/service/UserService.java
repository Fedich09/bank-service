package com.boot.bankservice.service;

import com.boot.bankservice.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    Optional<User> get(Long id);

    User update(User user);

    void delete(User user);

    User getByPhoneNumber(String number);
}
