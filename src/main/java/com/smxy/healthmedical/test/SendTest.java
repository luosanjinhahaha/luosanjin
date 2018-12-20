package com.smxy.healthmedical.test;

import com.smxy.healthmedical.mail.MailSenders;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
public class SendTest {
	public static int getRandNum(int min, int max) {
	    int randNum = min + (int)(Math.random() * ((max - min) + 1));
	    return randNum;
	}
	public static void main(String[] args) {
		int randNum = getRandNum(100000, 999999);
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mail.xml","applicationContext.xml");
        MailSenders sender = (MailSenders)ac.getBean("MailSender");
        SimpleMailMessage mailsender = new SimpleMailMessage();
        mailsender.setTo("792789101@qq.com");//收件人邮箱地址
        mailsender.setFrom("792789101@qq.com");//收件人
        mailsender.setSubject("注册验证码");//主题
        mailsender.setText(Integer.toString(randNum));//正文
        sender.send(mailsender);
    }
}
