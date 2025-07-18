package com.example.finance.application.presenters;

import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.dto.UserDto;
import com.example.finance.application.mapper.UserMapper;
import com.example.finance.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPresenter {
    private final UserService userService;
    private final UserMapper userMapper;

    public ResponseEntity<ResponseDto<UserDto>> presentById(Long id) {
        return ResponseEntity.ok(ResponseDto.<UserDto>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userMapper.toDto(userService.getById(id)))
                .build());
    }

    public ResponseEntity<ResponseDto<UserDto>> presentByEmail(String email) {
        return ResponseEntity.ok(ResponseDto.<UserDto>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(userMapper.toDto(userService.getByEmail(email)))
                .build());
    }
}
