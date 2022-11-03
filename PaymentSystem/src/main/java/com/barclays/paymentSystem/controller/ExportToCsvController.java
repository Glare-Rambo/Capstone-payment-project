package com.barclays.paymentSystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.exception.PaymentsException;
import com.barclays.paymentSystem.service.ExportToCsvService;

@RestController
@RequestMapping(value = "/transactions")
@Validated
public class ExportToCsvController {
	
	@Autowired
	ExportToCsvService exportToCsvService;
	
	@GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException, PaymentsException {
        response.setContentType("text/csv");
        
         
        exportToCsvService.listall(response);
        
         
    }
}
