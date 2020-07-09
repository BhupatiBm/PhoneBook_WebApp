package com.bit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.model.Contact;
import com.bit.service.ContactService;
@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;

	@GetMapping(value = {"/","/addcontact"})
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact",c);
		return "contactInfo";
	}

	@PostMapping(value = {"/savecontact"})
	public String handleSubmitBtn(@ModelAttribute("contact")Contact c, Model model) {
		boolean isSaved= contactService.saveContact(c);
		if(isSaved)
			return "redirect:/doublePost?y=true";
		else
			return "redirect:/doublePost?y=false";
	}

	@GetMapping(value = {"/viewAllContact"})
	public String handleViewContactsLink(Model model) {
		List<Contact> contactsList= new ArrayList();
		contactsList=contactService.getAllContacts();
		model.addAttribute("contactList",contactsList);
		//System.out.println(contactsList);
		return "viewContacts";
	}

	@GetMapping(value = {"/doublePost"})
	public String solveDoublePosting(@RequestParam("y")boolean y,Model model) {
		Contact c=new Contact();
		model.addAttribute("contact",c);
		if(y==true)
			model.addAttribute("sucmsg","rgistration done");
		else
			model.addAttribute("errmsg","rgistration done");
		return "contactInfo";
	}


}
