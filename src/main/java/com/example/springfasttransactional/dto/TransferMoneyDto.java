package com.example.springfasttransactional.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferMoneyDto {

    private int idFrom;
    private int idTo;
    private BigDecimal money;
}
