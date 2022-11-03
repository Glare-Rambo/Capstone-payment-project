package com.barclays.paymentSystem.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.barclays.paymentSystem.exception.PaymentsException;

public interface ExportToCsvService {
	
	void listall(HttpServletResponse response) throws IOException, PaymentsException;
}
