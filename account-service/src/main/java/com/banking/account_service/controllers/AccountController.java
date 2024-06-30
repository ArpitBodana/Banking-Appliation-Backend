package com.banking.account_service.controllers;

import com.banking.account_service.models.Account;
import com.banking.account_service.models.DepositOrDebit;
import com.banking.account_service.models.TransferDetails;
import com.banking.account_service.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccountDetails() {
        return new ResponseEntity<>(service.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAccount(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        return new ResponseEntity<>(service.addNewAccount(account), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        return new ResponseEntity<>(service.removeAccount(id), HttpStatus.GONE);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable Long id ,@RequestBody Account account){
        return  new ResponseEntity<>(service.updateAccount(account,id),HttpStatus.OK);
    }

    @PutMapping("/deposit")
    public ResponseEntity<String> depositToAccount(@RequestBody DepositOrDebit deposit){
        return  new ResponseEntity<>(service.depositToAccount(deposit.getAccountId(),deposit.getAmount()),HttpStatus.OK);
    }

    @PutMapping("/debit")
    public ResponseEntity<String> debitFromAccount(@RequestBody DepositOrDebit debit){
        return  new ResponseEntity<>(service.debitFromAccount(debit.getAccountId(),debit.getAmount()),HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public  ResponseEntity<String> transferAmount(@RequestBody TransferDetails transferDetails){
        return  new ResponseEntity<>(service.transferToAnotherAccount(transferDetails.getSenderId(),transferDetails.getReceiverId(), transferDetails.getTransferAmount()),HttpStatus.OK);
    }

}
