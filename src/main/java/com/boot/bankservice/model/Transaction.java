package com.boot.bankservice.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Column(name = "account_from")
    private Account accountFrom;
    @OneToOne
    @Column(name = "account_to")
    private Account accountTo;
    private LocalDateTime date;
    private Type type;

    private enum Type {
        INCOMING, OUTCOMING
    }


}
