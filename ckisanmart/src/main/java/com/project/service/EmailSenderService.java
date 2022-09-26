package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailsender;

	public void sendMail(String email, String subject, String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("kisanmart.cdac@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);
		mailsender.send(message);
		System.out.println("mail send sucessfully");
		
	}
	
}
