package com.barclays.paymentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.entity.Account;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.service.AccountService;

@RestController
@RequestMapping(value = "/account")
@Validated
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping(value = "/get-all-account-details")
	public ResponseEntity<List<Account>> getAllAccountDetails() throws PaymentsException {
		return accountService.getAllAccountDetails();
		
	}

}
