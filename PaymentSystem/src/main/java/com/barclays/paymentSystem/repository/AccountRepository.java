package com.barclays.paymentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
