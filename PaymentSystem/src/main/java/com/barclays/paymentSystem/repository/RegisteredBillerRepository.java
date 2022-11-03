package com.barclays.paymentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.RegisteredBiller;

public interface RegisteredBillerRepository extends JpaRepository<RegisteredBiller, Integer>{

	Iterable<RegisteredBiller> findByAccountNumber(Integer accountNumber);
}
