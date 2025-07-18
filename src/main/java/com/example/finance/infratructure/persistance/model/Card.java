package com.example.finance.infratructure.persistance.model;

import com.example.finance.domain.base.Auditable;
import com.example.finance.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Card extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "CARD_SEQUENCE")
    @SequenceGenerator(sequenceName = "CARD_SEQUENCE", allocationSize = 1, name = "CARD_SEQUENCE")
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
