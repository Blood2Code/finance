package com.example.finance.application.presenters;

import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.dto.TransactionDto;
import com.example.finance.application.mapper.TransactionMapper;
import com.example.finance.application.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TransactionPresenter {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    public ResponseEntity<ResponseDto<TransactionDto>> presentById(Long id) {
        return ResponseEntity.ok(ResponseDto.<TransactionDto>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(transactionMapper.toDto(transactionService.getById(id)))
                .build());
    }

    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentAllByUserId(Long userId) {
        return ResponseEntity.ok(ResponseDto.<List<TransactionDto>>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(transactionService.getAllByUser(userId).stream().map(transactionMapper::toDto).collect(Collectors.toList()))
                .build());
    }

    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentByUserCardId(Long userId) {
        return ResponseEntity.ok(ResponseDto.<List<TransactionDto>>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(transactionService.getAllByUserCardId(userId).stream().map(transactionMapper::toDto).collect(Collectors.toList()))
                .build());
    }

    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentAllByDateRange(LocalDate from, LocalDate to, Long userId) {
        return ResponseEntity.ok(ResponseDto.<List<TransactionDto>>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(transactionService.getAllByDateRange(from, to, userId).stream().map(transactionMapper::toDto).collect(Collectors.toList()))
                .build());
    }

    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentAll() {
        return ResponseEntity.ok(ResponseDto.<List<TransactionDto>>builder()
                .state(ResponseDto.States.SUCCESS)
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(transactionService.getAll().stream().map(transactionMapper::toDto).collect(Collectors.toList()))
                .build());
    }
}
