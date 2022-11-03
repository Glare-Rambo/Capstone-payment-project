package com.barclays.paymentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
