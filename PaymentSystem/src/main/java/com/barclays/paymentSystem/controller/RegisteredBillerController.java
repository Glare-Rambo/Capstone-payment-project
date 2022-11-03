package com.barclays.paymentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.entity.RegisteredBiller;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.service.ExportToCsvService;
import com.barclays.paymentSystem.service.RegisteredBillerService;
import com.barclays.paymentSystem.service.UserService;

@RestController
@RequestMapping(value = "/pay")
@Validated
public class RegisteredBillerController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegisteredBillerService registeredBillerService;
	
	@Autowired
	private ExportToCsvService exportToCsvService;

	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/registeredBillers")
	public ResponseEntity<List<RegisteredBiller>> getAllbillers() throws PaymentsException {
		return registeredBillerService.getAllBillers();
		
	}
	
	@GetMapping(value = "/registeredBillers/{sequenceId}")
	public ResponseEntity<List<RegisteredBiller>> getbillers(@PathVariable Integer sequenceId) throws PaymentsException {
		return registeredBillerService.getBillers(sequenceId);
		
	}
	
	@DeleteMapping(value = "/deleteBillers/{billerSequenceId}")
    public ResponseEntity<String> deletebiller(@PathVariable Integer billerSequenceId) throws PaymentsException {
        return registeredBillerService.deleteBiller(billerSequenceId);
        
    }
}
