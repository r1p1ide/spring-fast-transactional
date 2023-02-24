package com.example.springfasttransactional.repo;

import com.example.springfasttransactional.dto.TransferMoneyDto;
import com.example.springfasttransactional.dto.UpdateMoneyByIdDto;
import com.example.springfasttransactional.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

    List<Account> getAllAccounts();

    void createAccount(Account account);

    BigDecimal getMoneyById(int id);

    void updateMoneyById(UpdateMoneyByIdDto dto);

//    void transferMoney(TransferMoneyDto dto);
}
