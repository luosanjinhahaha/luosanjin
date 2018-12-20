package com.smxy.healthmedical.service;

import org.springframework.scheduling.annotation.Async;

public interface MailService {
	@Async
	String send(String email);
}
