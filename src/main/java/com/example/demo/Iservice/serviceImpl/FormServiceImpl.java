package com.example.demo.Iservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Iservice.FormService;


@Service
public class FormServiceImpl implements FormService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	

	@Override
	public boolean sendMail(String to, String subject, String text) {
		try {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        javaMailSender.send(message);
        return true;
		}
		catch(Exception e) {
			throw e;
		}
		
	}

}
