package com.example.finance.adapters.web;

import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.dto.UserDto;
import com.example.finance.application.presenters.UserPresenter;
import com.example.finance.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserPresenter userPresenter;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> create(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(ResponseDto.<UserDto>builder()
                        .status(HttpStatus.OK)
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .message("User Created")
                .data(userService.create(userDto))
                .build());
    }

    @PutMapping
    public ResponseEntity<ResponseDto<UserDto>> update(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(ResponseDto.<UserDto>builder()
                .status(HttpStatus.OK)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("User updated")
                .data(userService.update(userDto))
                .build());
    }

    @GetMapping("/by-id")
    public ResponseEntity<ResponseDto<UserDto>> getById(@RequestParam Long id) {
        return userPresenter.presentById(id);
    }

    @GetMapping("/by-email")
    public ResponseEntity<ResponseDto<UserDto>> getByEmail(@RequestParam String email) {
        return userPresenter.presentByEmail(email);
    }

}
