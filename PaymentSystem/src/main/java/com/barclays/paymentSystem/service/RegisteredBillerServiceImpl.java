package com.barclays.paymentSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barclays.paymentSystem.entity.RegisteredBiller;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.repository.RegisteredBillerRepository;

@Service(value="paymentService")
@Transactional
public class RegisteredBillerServiceImpl implements RegisteredBillerService {

	@Autowired
	private Environment environment;


	@Autowired
	private RegisteredBillerRepository registeredBillerRepository;
	
	public static final Log LOGGER = LogFactory.getLog(RegisteredBillerServiceImpl.class); //(RegisteredBillerServiceImpl.class);

	
	@Override
	public ResponseEntity<List<RegisteredBiller>> getAllBillers() throws PaymentsException {
	
		Iterable<RegisteredBiller> billers = registeredBillerRepository.findAll();
		List<RegisteredBiller> RegisteredBillerss = new ArrayList<>();
		billers.forEach(biller -> {
			RegisteredBiller rb = new RegisteredBiller();
			
			rb.setBillerCode(biller.getBillerCode());
			rb.setBillerSequenceId(biller.getBillerSequenceId());
			rb.setConsumerNumber(biller.getConsumerNumber());
			rb.setAccountNumber(biller.getAccountNumber());
			RegisteredBillerss.add(rb);
			
		});
		LOGGER.info("All billers Extracted");
		if (RegisteredBillerss.isEmpty())
			throw new PaymentsException("Service.BILLER_NOT_FOUND");
		
		return new ResponseEntity<>(RegisteredBillerss, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<RegisteredBiller>> getBillers(Integer AccountNumber) throws PaymentsException {
	
		Iterable<RegisteredBiller> billers = registeredBillerRepository.findByAccountNumber(AccountNumber);
		List<RegisteredBiller> RegisteredBillerss = new ArrayList<>();
		
		billers.forEach(biller -> {
			RegisteredBiller rb = new RegisteredBiller();
			
			rb.setBillerCode(biller.getBillerCode());
			rb.setBillerSequenceId(biller.getBillerSequenceId());
			rb.setConsumerNumber(biller.getConsumerNumber());
			rb.setAccountNumber(biller.getAccountNumber());
			RegisteredBillerss.add(rb);
		});
		if (RegisteredBillerss.isEmpty())
			throw new PaymentsException("Service.BILLER_NOT_FOUND");
		return new ResponseEntity<>(RegisteredBillerss, HttpStatus.OK);
		
	}
	
	@Override
    public ResponseEntity<String> deleteBiller(Integer billerSequenceId) throws PaymentsException {
        
        Optional<RegisteredBiller> register= registeredBillerRepository.findById(billerSequenceId);
        register.orElseThrow(() -> new PaymentsException("Service.BILLER_NOT_FOUND"));
        registeredBillerRepository.deleteById(billerSequenceId);
        String successMessage = environment.getProperty("API.BILLER_DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
        
    }

}
