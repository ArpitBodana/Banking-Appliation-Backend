package com.banking.account_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositOrDebit {
   private Long accountId;
   private Long amount;
}
