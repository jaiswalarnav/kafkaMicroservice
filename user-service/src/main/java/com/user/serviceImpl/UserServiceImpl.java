package com.user.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.user.model.Contact;
import com.user.model.User;
//import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	List<Contact> contacts;
	
	List<User> list=List.of(new User(1311L,"Arnav Jaiswal","9661518389"),
			new User(1312L,"Aditya Jaiswal","9939056844"),
			new User(1314L,"Aarav Jaiswal","7870834798"),
			new User(1315L,"Anubhav Jaiswal","8987344156"));
	
	public User getUser(Long id) {
	
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	
	
	}
	
	@KafkaListener(
			topics="contactList2",
			groupId="consumerGroup1",
			containerFactory = "concurrentKafkaListenerContainerFactory",autoStartup = "true")
	public void consume(@Payload List<Contact> contacts) {
		System.out.println("===============================>>>>>>>>>>>>>>>>>>");
		System.out.println(contacts);
		
		this.contacts = contacts;
	}
	
//	public List<Contact> getContacts(Long userId){
//		List<Contact> userContacts=new ArrayList<Contact>();
//		for(Contact contact:this.contacts)
//		{
//			if(contact.getUserId().equals(userId))
//				userContacts.add(contact);
//		}
//		return userContacts;
		
		public List<Contact> getContacts(){
			
			return this.contacts;
		
	}
	
	
	

}
