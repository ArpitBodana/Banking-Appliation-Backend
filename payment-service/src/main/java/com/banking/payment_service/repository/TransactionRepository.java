package com.banking.payment_service.repository;

import com.banking.payment_service.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions,Long> {
    List<Transactions> findByAccountId(Long accountId);
}
