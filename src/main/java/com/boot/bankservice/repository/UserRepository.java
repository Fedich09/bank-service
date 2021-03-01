package com.boot.bankservice.repository;

import com.boot.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM user u LEFT JOIN FETCH u.roles WHERE u.id = :id")
    Optional<User> getById(Long id);

    @Query("FROM user u LEFT JOIN FETCH u.roles WHERE u.phoneNumber = :number")
    Optional<User> getByPhoneNumber(String number);
}
