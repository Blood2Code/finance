package com.example.finance.application.service.impl;

import com.example.finance.application.dto.UserDto;
import com.example.finance.application.exception.BadRequestException;
import com.example.finance.application.exception.NotFoundException;
import com.example.finance.application.mapper.UserMapper;
import com.example.finance.application.service.UserService;
import com.example.finance.infratructure.persistance.model.User;
import com.example.finance.infratructure.persistance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto create(UserDto user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if(optionalUser.isEmpty()){
            throw new NotFoundException("User with email " + user.getEmail() + " already exists!");
        }

        return userMapper.toDto(userRepository.save(userMapper.toModel(user)));
    }

    @Override
    public UserDto update(UserDto user) {
        userRepository.findByIdOrEmail(user.getId(), user.getEmail()).orElseThrow(()-> new BadRequestException("User with  email " + user.getEmail() + " doesn't exists!"));

        return userMapper.toDto(userRepository.save(userMapper.toModel(user)));
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found with email: " + email));
    }

}
