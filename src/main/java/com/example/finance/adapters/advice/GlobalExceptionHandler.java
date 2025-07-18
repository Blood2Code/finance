package com.example.finance.adapters.advice;

import com.example.finance.application.dto.ResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ResponseDto<?>> notFoundException(ChangeSetPersister.NotFoundException exception) {
        return ResponseEntity.ok(
                ResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .build()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDto<?>> badRequestException(BadRequestException exception) {
        return ResponseEntity.ok(
                ResponseDto.builder()
                        .message(exception.getMessage())
                        .status(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

}
