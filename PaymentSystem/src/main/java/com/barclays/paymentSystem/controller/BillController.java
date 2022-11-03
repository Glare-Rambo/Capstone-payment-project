package com.barclays.paymentSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.entity.AccountTransaction;
import com.barclays.paymentSystem.entity.Bill;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.service.BillService;

@RestController
@RequestMapping(value = "/bills")
@Validated
public class BillController {

	@Autowired
	BillService billsService;
	

	@PostMapping(value = "/generateBill")
	public ResponseEntity<String> generatebill(@Valid @RequestBody Bill bills)
			throws PaymentsException {
		
		return billsService.generateBill(bills);
		
	}
	
	@GetMapping(value ="/getBills/{billerCode}")
	public ResponseEntity<List<String>> getbills(@PathVariable Integer billerCode) throws PaymentsException {
		return billsService.getBills(billerCode);
		
	}
	
	@GetMapping(value ="/get-all-Bills")
	public ResponseEntity<List<String>> getallbills() throws PaymentsException {
		return billsService.getAllBills();
		
	}
	
	@PostMapping(value = "/payment")
	public ResponseEntity<String> manualPay(@RequestBody AccountTransaction 
			accountTransaction)
			throws PaymentsException {
		
		return billsService.manualPay(accountTransaction);
		
	}
	
	@PostMapping(value = "/account-transaction-details")
	public ResponseEntity<String> accountTransactionDetails(@RequestBody AccountTransaction accountTransaction)
			throws PaymentsException {
		
		return billsService.accountTransactionDetails(accountTransaction);
		
	}
}
