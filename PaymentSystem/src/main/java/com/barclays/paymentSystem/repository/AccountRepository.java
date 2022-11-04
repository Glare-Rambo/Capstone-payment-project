package com.barclays.paymentSystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>{

}
