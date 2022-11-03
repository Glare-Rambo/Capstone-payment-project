package com.barclays.paymentSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	List<Bill> findByBillerCode(Integer billerCode);
}
