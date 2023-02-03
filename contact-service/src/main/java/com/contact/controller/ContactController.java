package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.model.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	

	@Autowired
	ContactService contactService;
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	
//	@GetMapping("/user/{userId}")
//	public List<Contact> getContacts(@PathVariable("userId") Long userId){
//		
//		return contactService.getContactsOfUser(userId);
//		
//	}
	
	@GetMapping("/user/{userId}")
	public List<Contact> getContact(@PathVariable("userId") Long userId){
		
		List<Contact> contacts= contactService.getContactsOfUser(userId);
		
		System.out.println("=>>>>>>>>>>>> @GetMapping"+contacts);
		
		contactService.sendMessage(contacts);
		
		return contacts;
		
	
		
	}

}
