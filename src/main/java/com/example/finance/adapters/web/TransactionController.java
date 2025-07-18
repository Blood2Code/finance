package com.example.finance.adapters.web;

import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.dto.TransactionDto;
import com.example.finance.application.presenters.TransactionPresenter;
import com.example.finance.application.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionPresenter transactionPresenter;
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<ResponseDto<TransactionDto>> create(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(ResponseDto.<TransactionDto>builder()
                .status(HttpStatus.OK)
                .status(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .message("User Created")
                .data(transactionService.create(transactionDto))
                .build());
    }

    @GetMapping("/by-id")
    public ResponseEntity<ResponseDto<TransactionDto>> presentById(@RequestParam Long id) {
        return transactionPresenter.presentById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentAll() {
        return transactionPresenter.presentAll();
    }

    @GetMapping("/by-user")
    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentByUserId(@RequestParam Long userId) {
        return transactionPresenter.presentAllByUserId(userId);
    }

    @GetMapping("/by-card")
    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentByCardId(@RequestParam Long cardId) {
        return transactionPresenter.presentByUserCardId(cardId);
    }

    @GetMapping("/by-date-range")
    public ResponseEntity<ResponseDto<List<TransactionDto>>> presentByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            @RequestParam Long userId // могли бы брать от токена если бы он был
            ) {

        return transactionPresenter.presentAllByDateRange(from, to, userId);
    }
}
