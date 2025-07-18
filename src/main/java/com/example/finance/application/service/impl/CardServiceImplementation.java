package com.example.finance.application.service.impl;

import com.example.finance.application.exception.BadRequestException;
import com.example.finance.application.exception.NotFoundException;
import com.example.finance.application.service.CardService;
import com.example.finance.infratructure.persistance.model.Card;
import com.example.finance.infratructure.persistance.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImplementation implements CardService {

    private final CardRepository cardRepository;

    @Override
    @Transactional(readOnly = true)
    public Card getById(Long id) {
        return cardRepository.findById(id).orElseThrow(()-> new NotFoundException("Card not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Card> getAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    @Transactional
    public void exchange(Long sourceCardId, Long destinationCardId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be greater than zero");
        }

        Card sC = getById(sourceCardId);
        Card dC = getById(destinationCardId);

        if (sC.getBalance().compareTo(amount) < 0) {
            throw new BadRequestException("Insufficient funds on source card");
        }

        if (sC.getId().equals(dC.getId())) {
            throw new BadRequestException("Cannot transfer to the same card");
        }

        sC.setBalance(sC.getBalance().subtract(amount));
        dC.setBalance(dC.getBalance().add(amount));

        cardRepository.saveAll(List.of(sC, dC));

    }
}
