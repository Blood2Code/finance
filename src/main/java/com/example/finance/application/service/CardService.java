package com.example.finance.application.service;

import com.example.finance.infratructure.persistance.model.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {

    Card getById(Long id);

    List<Card> getAllByUserId(Long userId);

    void exchange(Long sourceCardId, Long destinationCardId, BigDecimal amount);
}
