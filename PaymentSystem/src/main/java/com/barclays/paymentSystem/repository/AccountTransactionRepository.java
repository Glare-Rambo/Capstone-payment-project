package com.barclays.paymentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer>{

}
