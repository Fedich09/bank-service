package com.boot.bankservice.service.impl;

import com.boot.bankservice.exception.DataProcessingException;
import com.boot.bankservice.model.User;
import com.boot.bankservice.repository.UserRepository;
import com.boot.bankservice.service.UserService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getByPhoneNumber(String number) {
        return userRepository.getByPhoneNumber(number).orElseThrow(() ->
                new DataProcessingException("Can't get by phone number " + number));
    }
}
