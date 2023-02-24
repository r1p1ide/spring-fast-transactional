package com.example.springfasttransactional.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BaseResponse {

    private int status;
    private LocalDateTime dateTime;
    private boolean success;
}
