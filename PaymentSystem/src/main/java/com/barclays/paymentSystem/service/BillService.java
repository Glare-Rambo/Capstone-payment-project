package com.barclays.paymentSystem.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.entity.Account;
import com.barclays.paymentSystem.entity.AccountTransaction;
import com.barclays.paymentSystem.entity.Bill;
import com.barclays.paymentSystem.entity.EmailDetail;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.repository.AccountRepository;
import com.barclays.paymentSystem.repository.AccountTransactionRepository;
import com.barclays.paymentSystem.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billsRepository;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private AccountTransactionRepository accountTransactionRepository;
	
	@Autowired
	private AccountRepository accountsRepository;
	
	public ResponseEntity<String> generateBill(Bill bills) {
		Bill bill = new Bill();
		
		bill.setAmount(bills.getAmount());
		bill.setBillerCode(bills.getBillerCode());
		bill.setConsumerNumber(bills.getConsumerNumber());
		bill.setDueDate(bills.getDueDate());
		bill.setStatus(bills.getStatus());
		
		Bill bill2 = billsRepository.save(bill); //persisting data in database
		String successMessage = environment.getProperty("API.GENERATE_BILL")+ bill2.getBillSequenceId();
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	public ResponseEntity<List<String>> getBills(Integer billerCode) throws PaymentsException {
		Iterable<Bill> billers = billsRepository.findByBillerCode(billerCode);
		List<String> str = new ArrayList<>();
		
		billers.forEach(biller -> {
			String temp = "";
			String st="";
			
			if(biller.getStatus().equals(0))
			{ 
				temp = temp+"is Pending";
			}
			else if(biller.getStatus().equals(1))
			{ 
				temp = temp+"is Completed";
			}
			else if(biller.getStatus().equals(2))
			{ 
				temp = temp+"is Partially Paid";
			}
			else if(biller.getStatus().equals(3))
			{ 
				temp = temp+"has Passed due date";
			}
			st=st+"BillSequenceId:"+biller.getBillSequenceId()
			+" BillConsumerNumber:"+biller.getConsumerNumber()+" BillAmount : "+biller.getAmount() + " Bill payment " + temp;
			str.add(st);
			
			
		});
		
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	public ResponseEntity<List<String>> getAllBills() throws PaymentsException {
		Iterable<Bill> billers = billsRepository.findAll();
		List<String> str = new ArrayList<>();
		
		billers.forEach(biller -> {
			String temp = "";
			String st="";
			
			if(biller.getStatus().equals(0))
			{ 
				temp = temp+"is Pending";
			}
			else if(biller.getStatus().equals(1))
			{ 
				temp = temp+"is Completed";
			}
			else if(biller.getStatus().equals(2))
			{ 
				temp = temp+"is Partially Paid";
			}
			else if(biller.getStatus().equals(3))
			{ 
				temp = temp+"has Passed due date";
			}
			st=st+"BillSequenceId:"+biller.getBillSequenceId()
			+" BillConsumerNumber:"+biller.getConsumerNumber()+" BillAmount : "+biller.getAmount() + " Bill payment " + temp;
			str.add(st);
			
		});
		
		
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	public ResponseEntity<String> manualPay(AccountTransaction accountTransaction) throws PaymentsException {
		AccountTransaction accountTrans = new AccountTransaction();
		accountTrans.setAmount(accountTransaction.getAmount());
		accountTrans.setDate(LocalDate.now());
		accountTrans.setBill_ref_num(accountTransaction.getBill_ref_num());
		accountTrans.setSequence_id(accountTransaction.getSequence_id());
		accountTrans.setTransaction_type("Debit");
		accountTrans.setDescription(accountTransaction.getDescription());
		
		
		
		AccountTransaction accountTrans2 = accountTransactionRepository.save(accountTrans);
		
		Optional<Account> accounts= accountsRepository.findById(accountTransaction.getSequence_id());
		Account a = accounts.orElseThrow(() -> new PaymentsException("Service.USER_NOT_FOUND"));
		a.setCurrentBalance(a.getCurrentBalance()- accountTrans2.getAmount());
		
		Optional<Bill> bill= billsRepository.findById(accountTrans2.getBill_ref_num());
		
		Bill b= bill.orElseThrow(() -> new PaymentsException("Service.USER_NOT_FOUND"));
		
		b.setStatus(1);
		
		String successMessage = environment.getProperty("API.PAYMENT_SUCCESSFULL")+ accountTrans2.getBill_ref_num();;
		
		EmailDetail details=new EmailDetail();
		details.setRecipient(a.getEmail());
		details.setMsgBody("Payment Successful for Bill Number"+accountTrans2.getBill_ref_num());
		details.setSubject("Payment Information");
		//emailService.sendSimpleMail(details);
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	public ResponseEntity<String> accountTransactionDetails(AccountTransaction accountTransactions) {
		AccountTransaction accountTrans = new AccountTransaction();
		
		accountTrans.setTrans_ref_num(accountTransactions.getTrans_ref_num());
		accountTrans.setSequence_id(accountTransactions.getSequence_id());
		accountTrans.setAmount(accountTransactions.getAmount());
		accountTrans.setBill_ref_num(accountTransactions.getBill_ref_num());
		accountTrans.setDate(LocalDate.now());
		accountTrans.setDescription(accountTransactions.getDescription());
		accountTrans.setTransaction_type(accountTransactions.getTransaction_type());
		
		
		AccountTransaction accountTrans2 = accountTransactionRepository.save(accountTrans); //persisting data in database
		String successMessage = environment.getProperty("API.ACCOUNT_TRANSACTION_DONE")+ accountTrans2.getBill_ref_num();
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
}
