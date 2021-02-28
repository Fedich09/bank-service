package com.boot.bankservice.repository;

import com.boot.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @Query("from user u left join fetch u.roles where u.id = :id")
    Optional<User> findById(@Param("id") Long id);

    @Query("from user u left join fetch u.roles where u.phoneNumber = :number")
    Optional<User> getByPhoneNumber(@Param("number") String number);
}
