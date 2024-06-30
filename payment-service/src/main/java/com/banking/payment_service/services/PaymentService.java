package com.banking.payment_service.services;

import com.banking.payment_service.feign.AccountInterface;
import com.banking.payment_service.models.*;
import com.banking.payment_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PaymentService  {

    @Autowired
    AccountInterface accountInterface;

    @Autowired
    TransactionRepository transactionRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");


    public String depositToAccount(DepositOrDebit deposit) {
        Account account = getMyAccountInfo(deposit.getAccountId());
        if(account.getId()!=null){
            Transactions transactions = new Transactions(0L,deposit.getAmount(),TransactionTypes.DEPOSIT,formatter.format(new Date()),0L,deposit.getAccountId());
            transactionRepository.save(transactions);
        }
        return accountInterface.depositToAccount(deposit).getBody();
    }

    public String debitFromAccount(DepositOrDebit debit) {
        Account account = getMyAccountInfo(debit.getAccountId());
        if(account.getId()!=null){
            Transactions transactions = new Transactions(0L,debit.getAmount(),TransactionTypes.DEBIT,formatter.format(new Date()),0L,debit.getAccountId());
            transactionRepository.save(transactions);
        }
        return accountInterface.debitFromAccount(debit).getBody();
    }

    public String transferToAnotherAccount(TransferDetails transferDetails) {
        Account account = getMyAccountInfo(transferDetails.getSenderId());
        if(account.getId()!=null){
            Transactions transactions = new Transactions(0L,transferDetails.getTransferAmount(),TransactionTypes.TRANSFER,formatter.format(new Date()),transferDetails.getReceiverId(),transferDetails.getSenderId());
            transactionRepository.save(transactions);
        }

        return accountInterface.transferAmount(transferDetails).getBody();
    }

    private Account getMyAccountInfo(Long id){
        return  accountInterface.getAccount(id).getBody();
    }

    public List<Transactions> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public List<Transactions> getMyTransactions(Long id){
        return transactionRepository.findByAccountId(id).stream().sorted((a,n)->n.getId()>a.getId()?1:-1).collect(Collectors.toList());
    }

}
