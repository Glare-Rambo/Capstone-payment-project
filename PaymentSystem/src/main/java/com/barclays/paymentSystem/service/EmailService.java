package com.barclays.paymentSystem.service;

import com.barclays.paymentSystem.entity.EmailDetail;

public interface EmailService {

	String sendSimpleMail(EmailDetail details);
	String sendMailWithAttachment(EmailDetail details);
}
