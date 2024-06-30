package com.banking.payment_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDetails {
    private Long senderId;
    private Long receiverId;
   private Long transferAmount;
}
