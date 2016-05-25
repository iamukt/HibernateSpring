package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

/*
 * commented above statements since trying CRUD with Customer controller
 */
//@Controller
//@RequestMapping("/cust")
public class LoginController {
	// how to tell SC -- to inject service bean
	@Autowired
	@Qualifier("dao_based_service")
	private CustomerService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model map) {
		// Model --- map of model attributes
		System.out.println("in show login form " + map);
		// create empty DTO(model) instance & add it modl atter map
		// Model API --- public void addAttribute(String attrName,Object val);
		map.addAttribute("custModel", new Customer());
		return "login";
	}

	// method for processing login form
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(
			@Valid @ModelAttribute("custModel") Customer c, BindingResult res,
			Model map, HttpSession hs) {
		System.out.println("in process login form " + c);
		// chk for p.l errs
		if (res.hasFieldErrors("email") || res.hasFieldErrors("pass")) {
			// p.l errs
			System.out.println("P.L errors");
			return "login";
		}
		System.out.println("no p .l errs");
		// use service layer bean for validation
		Customer details = service.validateCustomer(c.getEmail(), c.getPassword());
		if (details == null)
			return "invalid";
		// successful B.L validations
		// add validated cust details to model attr map
		map.addAttribute("valid_cust", details);
		map.addAttribute("status", "Logged in Successfully");
		System.out.println("login " + hs.getId());
		// add validated user dtls to session scope
		hs.setAttribute("valid_cust", details);
		return "valid";
	}
}
