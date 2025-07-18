package com.example.finance.infratructure.persistance.model;

import com.example.finance.domain.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "USER_SEQUENCE")
    @SequenceGenerator(sequenceName = "USER_SEQUENCE", allocationSize = 1, name = "USER_SEQUENCE")
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;
}
