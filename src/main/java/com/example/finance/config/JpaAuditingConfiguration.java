package com.example.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
//    @Bean
//    public AuditorAware<String> auditorProvider() {
//        return () -> {
//            Optional<String> username;
//            if (SecurityContextHolder.getContext().getAuthentication() == null) {
//                username = Optional.of("admin");
//            } else
//                username = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
//            return username;
//        };
//    }
}

