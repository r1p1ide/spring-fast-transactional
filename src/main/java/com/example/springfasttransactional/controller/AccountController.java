package com.example.springfasttransactional.controller;

import com.example.springfasttransactional.dto.CreateAccountDto;
import com.example.springfasttransactional.dto.TransferMoneyDto;
import com.example.springfasttransactional.service.AccountService;
import com.example.springfasttransactional.util.BaseResponse;
import com.example.springfasttransactional.util.GetAllAccountsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/get")
    public ResponseEntity<GetAllAccountsResponse> getAllAccounts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GetAllAccountsResponse(
                        200, LocalDateTime.now(), true, accountService.getAllAccounts()));
    }

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<BaseResponse> createAccount(@RequestBody CreateAccountDto dto) {

        accountService.createAccount(dto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new BaseResponse(200, LocalDateTime.now(), true));
    }

    @PostMapping(value = "/transfer", produces = "application/json")
    public ResponseEntity<BaseResponse> transferMoney(@RequestBody TransferMoneyDto dto) {

        accountService.transferMoney(dto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new BaseResponse(200, LocalDateTime.now(), true));
    }
}
