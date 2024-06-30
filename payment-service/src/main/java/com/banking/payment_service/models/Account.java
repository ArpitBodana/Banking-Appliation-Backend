package com.banking.payment_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private Long id;
    private String accountHolder;
    private Long accountBalance;
    private Boolean isActive;

}
