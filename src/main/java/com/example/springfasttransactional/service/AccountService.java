package com.example.springfasttransactional.service;

import com.example.springfasttransactional.dto.CreateAccountDto;
import com.example.springfasttransactional.dto.TransferMoneyDto;
import com.example.springfasttransactional.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    void createAccount(CreateAccountDto dto);

    void transferMoney(TransferMoneyDto dto);
}
