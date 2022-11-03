package com.barclays.paymentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barclays.paymentSystem.repository.RegisteredBillerRepository;

@Service(value="paymentService")
@Transactional
public class RegisteredBillerServiceImpl {

	@Autowired
	private Environment environment;


	@Autowired
	private RegisteredBillerRepository registeredBillerRepository;
}
