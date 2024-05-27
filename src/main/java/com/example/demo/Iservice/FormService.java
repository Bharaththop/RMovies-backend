package com.example.demo.Iservice;

import org.springframework.stereotype.Service;

@Service
public interface FormService {

	public boolean sendMail(String to, String subject, String text);
}
