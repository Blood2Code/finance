package com.example.finance.infratructure.persistance.model;

import com.example.finance.domain.base.Auditable;
import com.example.finance.domain.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Transaction extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "TRANSACTION_SEQUENCE")
    @SequenceGenerator(sequenceName = "TRANSACTION_SEQUENCE", allocationSize = 1, name = "TRANSACTION_SEQUENCE")
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String comment;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Card sourceCard;

    @ManyToOne(fetch = FetchType.LAZY)
    private Card destinationCard;
}
