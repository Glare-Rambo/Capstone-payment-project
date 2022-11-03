package com.barclays.paymentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.service.EmailService;

@RestController
public class EmailController {

	@Autowired 
	private EmailService emailService;
}
