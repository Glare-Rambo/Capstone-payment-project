package com.barclays.paymentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.service.BillService;

@RestController
@RequestMapping(value = "/bills")
@Validated
public class BillController {

	@Autowired
	BillService billsService;
}
