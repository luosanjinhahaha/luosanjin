package com.smxy.healthmedical.utils;

import com.smxy.healthmedical.mail.MailSenders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailSenderUtils {
	@Autowired
	MailSenders mailSender;
	public static int getRandNum(int min, int max) {
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randNum;
	}

	public  String mailsender(String email) throws InterruptedException {
		int randNum = getRandNum(100000, 999999);
        SimpleMailMessage mailsender = new SimpleMailMessage();
        mailsender.setTo(email);//收件人邮箱地址
        mailsender.setFrom("792789101@qq.com");//发件人
        mailsender.setSubject("注册验证码");//主题
		mailsender.setText(Integer.toString(randNum));//正文
		mailSender.send(mailsender);
		return Integer.toString(randNum);
    }
}
