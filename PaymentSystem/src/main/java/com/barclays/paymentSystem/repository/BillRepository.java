package com.barclays.paymentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.paymentSystem.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
