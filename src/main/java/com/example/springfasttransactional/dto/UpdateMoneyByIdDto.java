package com.example.springfasttransactional.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMoneyByIdDto {

    private int id;
    private BigDecimal money;
}
