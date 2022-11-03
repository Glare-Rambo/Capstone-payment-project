package com.barclays.paymentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

	@Autowired
	private JavaMailSender javaMailSender;
	
	 @Value
	 ("${spring.mail.username}") private String sender;
}
