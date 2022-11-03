package com.barclays.paymentSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.barclays.paymentSystem.entity.User;
import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.repository.UserRepository;



@Service(value = "userService")
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private Environment environment;
	
	public User registerUser(User user) {
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
	
	public ResponseEntity<String> loginUser(User User) throws PaymentsException {
		Optional<User> optional = userRepository.findById(User.getLoginId());
		User user = optional.orElseThrow(() -> new PaymentsException("Service.USERS_NOT_FOUND"));
		if (user.getPassword().equals(User.getPassword())) {
			String successMessage = environment.getProperty("API.LOGGED_IN") + user.getLoginId() + " AS "
					+ user.getRoleName();
			return new ResponseEntity<>(successMessage, HttpStatus.CREATED);

		} else {
			throw new PaymentsException("Service.INCORRECT");
		}
	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
