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
	
	
	public User addUser(User user) {
		User user1 = new User();
		user1.setLoginId(user.getLoginId());
		user1.setPassword(user.getPassword());
		user1.setRoleName(user.getRoleName());
		user1.setLinkedAccountSequenceId(user.getLinkedAccountSequenceId());
		if (user.getRoleName().equals("Bank_Manager")) {
			user1.setRoleId(1);
		} else {
			user1.setRoleId(2);
		}

		return userRepository.save(user1);
	}

}
