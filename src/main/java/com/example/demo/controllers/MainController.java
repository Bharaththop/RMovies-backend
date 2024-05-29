package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Iservice.FormService;
import com.example.demo.models.FormData;



@RestController
public class MainController {
	
	@Autowired
	FormService formService;
	
	
	@PostMapping("/sendMail")
	@CrossOrigin(origins={"https://r-movies-sepia.vercel.app","https://r-movies-sepia.vercel.app/homepage/contact-form"})
	public ResponseEntity<Boolean> toSendEmail(@RequestBody FormData formData) {
		boolean isSent=false;
		String subject = "Data Submission from " + formData.getFirstName() + " " + formData.getLastName();
        String text = "Project Name: " + formData.getProjectName() + "\n" +
                      "Email: " + formData.getEmail() + "\n" +
                      "Phone Number: " + formData.getPhoneNumber() + "\n" +
                      "Description: " + formData.getDescription();
		isSent=formService.sendMail("dudipalabharath2@gmail.com",subject,text);
		HttpStatusCode status= HttpStatus.OK;
		return new ResponseEntity<>(isSent,status);
		
	}
	
	@GetMapping("/get")
	@CrossOrigin(origins={"http://localhost:4200","http://localhost:4200/contact-form"})
	public String getMapping() {
		return "There is there";
	}

}
