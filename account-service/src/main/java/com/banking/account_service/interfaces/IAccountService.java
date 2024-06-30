package com.banking.account_service.interfaces;

import com.banking.account_service.models.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> getAllAccounts();
    Account getAccount(Long id);
    String addNewAccount(Account account);
    String removeAccount(Long id);
    String updateAccount(Account account, Long id);
    String depositToAccount(Long accountId,Long depositAmount);
    String debitFromAccount(Long accountId,Long debitAmount);
    String transferToAnotherAccount(Long senderId, Long reciverId, Long transferAmount);
}
