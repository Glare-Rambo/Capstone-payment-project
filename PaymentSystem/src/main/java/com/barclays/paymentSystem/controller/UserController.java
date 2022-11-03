package com.barclays.paymentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.entity.User;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.service.UserService;

@RestController
@RequestMapping(value = "/users")
@Validated
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/get-all-user")
	public ResponseEntity<List<User>> getAllusers() throws PaymentsException {
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}
}
