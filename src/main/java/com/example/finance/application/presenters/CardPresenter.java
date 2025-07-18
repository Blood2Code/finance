package com.example.finance.application.presenters;

import com.example.finance.application.dto.CardDto;
import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.mapper.CardMapper;
import com.example.finance.application.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CardPresenter {

    private final CardService cardService;
    private final CardMapper cardMapper;

    public ResponseEntity<ResponseDto<CardDto>> presentById(Long id) {
        return ResponseEntity.ok(ResponseDto.<CardDto>builder()
                    .state(ResponseDto.States.SUCCESS)
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .message(HttpStatus.OK.getReasonPhrase())
                    .data(cardMapper.toDto(cardService.getById(id)))
                .build());
    }

    public ResponseEntity<ResponseDto<List<CardDto>>> presentAllByUserId(Long userId) {
        return ResponseEntity.ok(ResponseDto.<List<CardDto>>builder()
                    .state(ResponseDto.States.SUCCESS)
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .message(HttpStatus.OK.getReasonPhrase())
                    .data(cardService.getAllByUserId(userId).stream().map(cardMapper::toDto).collect(Collectors.toList()))
                .build());
    }
}
