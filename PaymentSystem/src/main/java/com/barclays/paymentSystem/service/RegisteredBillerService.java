package com.barclays.paymentSystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.barclays.paymentSystem.entity.RegisteredBiller;
import com.barclays.paymentSystem.exception.PaymentsException;

public interface RegisteredBillerService {

	ResponseEntity<List<RegisteredBiller>> getAllBillers() throws PaymentsException;
	
	ResponseEntity<List<RegisteredBiller>> getBillers(Integer sequenceId) throws PaymentsException;

	
}
