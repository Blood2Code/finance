package com.example.finance.application.mapper;

import com.example.finance.application.dto.UserDto;
import com.example.finance.infratructure.persistance.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toModel(UserDto userDto);
}
