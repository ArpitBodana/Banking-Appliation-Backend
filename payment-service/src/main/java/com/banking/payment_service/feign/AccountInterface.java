package com.banking.payment_service.feign;


import com.banking.payment_service.models.Account;
import com.banking.payment_service.models.DepositOrDebit;
import com.banking.payment_service.models.TransferDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@FeignClient(name="BANK-ACCOUNT-SERVICE",path = "api/v1/account")
public interface AccountInterface {
    @PutMapping ("/deposit")
    public ResponseEntity<String> depositToAccount(@RequestBody DepositOrDebit deposit);

    @PutMapping("/debit")
    public ResponseEntity<String> debitFromAccount(@RequestBody DepositOrDebit debit);

    @PutMapping("/transfer")
    public  ResponseEntity<String> transferAmount(@RequestBody TransferDetails transferDetails);

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id);
}
