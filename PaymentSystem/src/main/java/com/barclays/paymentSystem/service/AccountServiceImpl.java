package com.barclays.paymentSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.entity.Account;
import com.barclays.paymentSystem.entity.RegisteredBiller;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {


	@Autowired
	AccountRepository accountRepository;
	


	public ResponseEntity<List<Account>> getAllAccountDetails() throws PaymentsException{
		Iterable<Account> accounts=accountRepository.findAll();
		
		List<Account> accountLs=new ArrayList<Account>();
		accounts.forEach(account -> {
			Account ac = new Account();
			
			ac.setAccountNo(account.getAccountNo());
			ac.setName(account.getName());
			ac.setEmail(account.getEmail());
			ac.setCurrentBalance(account.getCurrentBalance());
			ac.setBillSequenceId(account.getBillSequenceId());
			accountLs.add(ac);
			
		});
		if (accountLs.isEmpty())
			throw new PaymentsException("Service.BILLER_NOT_FOUND");
		
		return new ResponseEntity<>(accountLs, HttpStatus.OK);
	}
}
