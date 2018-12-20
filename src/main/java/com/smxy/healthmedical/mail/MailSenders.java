package com.smxy.healthmedical.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenders {
	@Autowired
	private JavaMailSender mailSender;
	public void send(SimpleMailMessage mail){
		mailSender.send(mail);
	}

}
