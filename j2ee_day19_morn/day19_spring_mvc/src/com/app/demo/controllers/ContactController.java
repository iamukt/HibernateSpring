package com.app.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.demo.model.Contact;
import com.app.demo.service.ContactService;

@Controller
@RequestMapping("/cust")
public class ContactController {
	@Autowired
	// by type
	private ContactService service;

	public ContactController() {
		System.out.println("in contact controller constr");
	}

	// req handling method to display login form
	@RequestMapping(value = "/login")
	public String showLoginForm(Model map) {
		System.out.println("in show login form " + map);
		// add like MDI in struts -- EMPTY model instance to the map
		map.addAttribute("contact", new Contact());
		return "login";
	}

	// req handling method to process login form
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(Contact c, Model map) {
		System.out.println("in process login form " + c);
		System.out.println("in process login form " + map);
		try {
			Contact validCust = service.validateContact(c.getEmail(),
					c.getPassword());
			if (validCust != null) {
				// add validCust in model map
				map.addAttribute("valid_contact", validCust);
				return "details";
			}
		} catch (Exception e) {
			System.out.println("err in controller " + e);
			map.addAttribute("status", "Server internal error : Invalid Login");
			return "login";
		}
		map.addAttribute("status", "Invalid Login : pls retry");
		return "login";
	}

}
