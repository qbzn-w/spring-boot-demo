package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	JavaMailSenderImpl javaMailSender;
	@Test
	void contextLoads() throws MessagingException {


	}
	@Test
	public void sendMail() throws MessagingException {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		String subject="hello world";
		String content="<h1>测试html邮件发送</h1>";
		boolean isHtml=true;
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setFrom("15705817983@163.com");
		mimeMessageHelper.setTo("770073679@qq.com"); //接受人
		mimeMessageHelper.setSubject(subject); //设置主题
		mimeMessageHelper.setText(content,isHtml);  //发送内容
		javaMailSender.send(mimeMessage);
		System.out.println("发送成功");

	}


}
