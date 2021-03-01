package com.boot.bankservice.model;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    private String password;
    @ManyToMany
    private Set<Role> roles;
}
