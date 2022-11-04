package com.barclays.paymentSystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.barclays.paymentSystem.entity.Account;
import com.barclays.paymentSystem.entity.RegisteredBiller;
import com.barclays.paymentSystem.exception.PaymentsException;

public interface AccountService {


	public ResponseEntity<List<Account>> getAllAccountDetails() throws PaymentsException;

}
