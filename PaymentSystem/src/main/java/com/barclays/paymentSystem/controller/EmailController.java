package com.barclays.paymentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.paymentSystem.entity.EmailDetail;
import com.barclays.paymentSystem.service.EmailService;

@RestController
public class EmailController {

	@Autowired 
	private EmailService emailService;
	
	@PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailDetail details)
    {
        String status
            = emailService.sendSimpleMail(details);
 
        return status;
    }
    
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
        @RequestBody EmailDetail details)
    {
        String status
            = emailService.sendMailWithAttachment(details);
 
        return status;
    }
}
