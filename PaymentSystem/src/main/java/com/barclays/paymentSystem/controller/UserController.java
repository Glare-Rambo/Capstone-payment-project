package com.barclays.paymentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.service.UserService;

@RestController
@RequestMapping(value = "/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;
}
