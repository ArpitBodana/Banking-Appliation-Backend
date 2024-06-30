package com.banking.payment_service.controllers;


import com.banking.payment_service.models.DepositOrDebit;
import com.banking.payment_service.models.Transactions;
import com.banking.payment_service.models.TransferDetails;
import com.banking.payment_service.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @PutMapping("/depositToAccount")
    public ResponseEntity<String> depositMoney(@RequestBody DepositOrDebit deposit){
        return new ResponseEntity<>(paymentService.depositToAccount(deposit), HttpStatus.OK);
    }

    @PutMapping("/debitFromAccount")
    public ResponseEntity<String> debitMoney(@RequestBody DepositOrDebit debit){
        return  new ResponseEntity<>(paymentService.debitFromAccount(debit),HttpStatus.OK);
    }

    @PutMapping("/transferToAccount")
    public  ResponseEntity<String> transferMoney(@RequestBody TransferDetails transferDetails){
        return  new ResponseEntity<>(paymentService.transferToAnotherAccount(transferDetails),HttpStatus.OK);
    }

    @GetMapping("/getTransactions")
    public ResponseEntity<List<Transactions>> getAllTransactions(){
        return new ResponseEntity<>(paymentService.getAllTransactions(),HttpStatus.OK);
    }

    @GetMapping("/getMyTransactions")
    public ResponseEntity<List<Transactions>> getMyTransactions(@RequestParam Long id){
        return new ResponseEntity<>(paymentService.getMyTransactions(id),HttpStatus.OK);
    }


}
