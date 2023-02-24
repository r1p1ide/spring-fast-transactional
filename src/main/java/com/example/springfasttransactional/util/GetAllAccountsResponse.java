package com.example.springfasttransactional.util;

import com.example.springfasttransactional.model.Account;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetAllAccountsResponse extends BaseResponse {

    private final List<Account> accounts;

    public GetAllAccountsResponse(int status, LocalDateTime dateTime, boolean success, List<Account> accounts) {
        super(status, dateTime, success);
        this.accounts = accounts;
    }
}
