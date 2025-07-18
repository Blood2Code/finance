package com.example.finance.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {

    public enum States {SUCCESS, ERROR, INFO, WARNING, EXPIRED_TEST_DATE, CONFLICT}

    private States state;

    private HttpStatus status;

    private Integer statusCode;

    private String message;

    private T data;
}
