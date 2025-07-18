package com.example.finance.application.service;

import com.example.finance.application.dto.TransactionDto;
import com.example.finance.infratructure.persistance.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    TransactionDto create(TransactionDto transactionDto);

    Transaction getById(Long id);

    List<Transaction> getAllByUserCardId(Long cardId);

    List<Transaction> getAllByUser(Long userId);

    List<Transaction> getAll();

    List<Transaction> getAllByDateRange(LocalDate from, LocalDate to, Long userId);

}
