package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.service.MailService;
import com.smxy.healthmedical.utils.MailSenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MailSenderImpl implements MailService {
	@Autowired
	MailSenderUtils mailSenderUtils;
	@Override
	public String send(String email) {
		try {
			return mailSenderUtils.mailsender(email);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
