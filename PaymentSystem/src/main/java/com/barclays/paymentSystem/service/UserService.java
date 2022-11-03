package com.barclays.paymentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.entity.User;
import com.barclays.paymentSystem.repository.UserRepository;



@Service(value = "userService")
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private Environment environment;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
