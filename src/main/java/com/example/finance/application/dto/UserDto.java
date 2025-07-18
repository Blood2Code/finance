package com.example.finance.application.dto;

import com.example.finance.domain.base.Auditable;
import com.example.finance.domain.enums.Status;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserDto extends Auditable<Long> {
    private Long id;

    private String name;

    private Status status;

    private String email;
}
