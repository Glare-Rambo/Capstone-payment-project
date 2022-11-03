package com.barclays.paymentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.repository.AccountTransactionRepository;

@Service
public class ExportToCsvServiceImpl {

	@Autowired
	AccountTransactionRepository accountTransactionRepository;
}
