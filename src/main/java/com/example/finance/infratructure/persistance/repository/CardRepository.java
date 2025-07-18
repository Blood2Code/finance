package com.example.finance.infratructure.persistance.repository;

import com.example.finance.infratructure.persistance.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
