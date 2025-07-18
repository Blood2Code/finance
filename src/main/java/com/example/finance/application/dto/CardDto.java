package com.example.finance.application.dto;

import com.example.finance.domain.base.Auditable;
import com.example.finance.domain.enums.Status;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CardDto extends Auditable<Long> {
    private Long id;

    private String name;

    private BigDecimal balance;

    private Status status;

    private UserDto user;
}
