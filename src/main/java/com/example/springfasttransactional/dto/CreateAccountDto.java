package com.example.springfasttransactional.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountDto {

    private String name;
    private BigDecimal balance;
}
