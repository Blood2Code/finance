package com.example.finance.application.service;

import com.example.finance.application.dto.UserDto;
import com.example.finance.infratructure.persistance.model.User;

public interface UserService {

    UserDto create(UserDto user);

    UserDto update(UserDto user);

    User getById(Long id);

    User getByEmail(String email);

}
