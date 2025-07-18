package com.example.finance.application.mapper;

import com.example.finance.application.dto.TransactionDto;
import com.example.finance.application.dto.UserDto;
import com.example.finance.infratructure.persistance.model.Transaction;
import com.example.finance.infratructure.persistance.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto toDto(Transaction transaction);
    Transaction toModel(TransactionDto transactionDto);
}
