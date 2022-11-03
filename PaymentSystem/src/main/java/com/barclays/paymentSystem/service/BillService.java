package com.barclays.paymentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billsRepository;
	
	@Autowired
	private Environment environment;
}
