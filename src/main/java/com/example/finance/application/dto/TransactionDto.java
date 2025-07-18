package com.example.finance.application.dto;


import com.example.finance.domain.base.Auditable;
import com.example.finance.domain.enums.TransactionStatus;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class TransactionDto extends Auditable<Long> {
    private Long id;

    private String comment;

    private BigDecimal amount;

    private TransactionStatus status;

    private CardDto sourceCard;

    private CardDto destinationCard;
}
