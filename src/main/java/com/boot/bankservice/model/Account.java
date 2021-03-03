package com.boot.bankservice.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "account")
@ToString(exclude = "user")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_number", unique = true)
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private BigDecimal balance;
    @Column(name = "is_active")
    private Boolean isActive;
    @ManyToOne
    private User user;
}
