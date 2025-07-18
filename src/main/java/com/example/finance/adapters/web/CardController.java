package com.example.finance.adapters.web;

import com.example.finance.application.dto.CardDto;
import com.example.finance.application.dto.ResponseDto;
import com.example.finance.application.presenters.CardPresenter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardPresenter cardPresenter;

    @GetMapping("/by-id")
    public ResponseEntity<ResponseDto<CardDto>> presentById(@RequestParam Long id) {
        return cardPresenter.presentById(id);
    }

    @GetMapping("/by-user")
    public ResponseEntity<ResponseDto<List<CardDto>>> presentByUserId(@RequestParam Long userId) {
        return cardPresenter.presentAllByUserId(userId);
    }
}
