package com.barclays.paymentSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.repository.UserRepository;

@Service(value = "userService")
public class UserService {

	@Autowired
	UserRepository userRespository;

	@Autowired
	private Environment environment;
}
