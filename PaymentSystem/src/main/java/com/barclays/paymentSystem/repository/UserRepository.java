package com.barclays.paymentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
