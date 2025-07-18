package com.example.finance.application.service.impl;

import com.example.finance.application.dto.TransactionDto;
import com.example.finance.application.exception.NotFoundException;
import com.example.finance.application.mapper.TransactionMapper;
import com.example.finance.application.service.CardService;
import com.example.finance.application.service.TransactionService;
import com.example.finance.domain.enums.TransactionStatus;
import com.example.finance.infratructure.persistance.model.Transaction;
import com.example.finance.infratructure.persistance.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImplementation implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @Override
    @Transactional
    public TransactionDto create(TransactionDto transactionDto) {

        cardService.exchange(transactionDto.getSourceCard().getId(), transactionDto.getDestinationCard().getId(), transactionDto.getAmount());

        transactionDto.setStatus(TransactionStatus.SUCCESS);

        return transactionMapper.toDto(transactionRepository.save(transactionMapper.toModel(transactionDto)));
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction getById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllByUserCardId(Long cardId) {
        return transactionRepository.findAllBySourceCard_Id(cardId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllByUser(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllByDateRange(LocalDate from, LocalDate to, Long userId) {
        Date fromDate = Date.from(from.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date toDate = Date.from(to.atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant());

        return transactionRepository.findAllByCreatedDateBetweenAndSourceCard_User_Id(fromDate, toDate, userId);
    }

}
