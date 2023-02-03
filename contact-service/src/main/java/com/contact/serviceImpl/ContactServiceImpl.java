package com.contact.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.contact.model.Contact;
import com.contact.service.ContactService;


@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	List<Contact> list=List.of(new Contact(101L,"amit@gmail.com","amit",1311L),
			new Contact(102L,"aayush@gmail.com","aayush",1311L),
			new Contact(103L,"sagar@gmail.com","sagar",1312L),
			new Contact(104L,"dhanush@gmail.com","dhanush",1314L));
	
	
public	List<Contact> getContactsOfUser(Long userId){
		
		return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList());
		
	}

public void sendMessage(List<Contact> contacts) {
	
	System.out.println("=>>>>>>>>>>>> sendMessage"+contacts);
	
	Message<List<Contact>> message = MessageBuilder.withPayload(contacts).setHeader(KafkaHeaders.TOPIC, "contactList2").build();
	kafkaTemplate.send(message);
}


}
