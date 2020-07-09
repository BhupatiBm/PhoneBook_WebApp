package com.bit.service;

import java.util.List;

import com.bit.model.Contact;

public interface ContactService {
	boolean saveContact(Contact c);
	List<Contact> getAllContacts( );
	Contact getContactById(Integer cid);
	boolean updateContact(Contact c);
	boolean deleteContact(Integer cid);

}
