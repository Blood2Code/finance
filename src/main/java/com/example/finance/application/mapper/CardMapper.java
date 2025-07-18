package com.example.finance.application.mapper;

import com.example.finance.application.dto.CardDto;
import com.example.finance.application.dto.UserDto;
import com.example.finance.infratructure.persistance.model.Card;
import com.example.finance.infratructure.persistance.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardDto toDto(Card card);
    Card toModel(CardDto cardDto);
}
