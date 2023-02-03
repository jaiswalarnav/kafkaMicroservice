package com.contact.service;

import java.util.List;

import com.contact.model.Contact;

public interface ContactService {
	
	public List<Contact> getContactsOfUser(Long userId);
	
	public void sendMessage(List<Contact> contact);

}
