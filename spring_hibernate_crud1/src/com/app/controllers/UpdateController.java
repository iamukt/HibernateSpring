package com.app.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

/*@Controller
@RequestMapping("/cust")*/
public class UpdateController {
	// dependency
	// how to tell SC -- to inject service bean
	@Autowired
	@Qualifier("dao_based_service")
	private CustomerService service;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String showUpdateForm(Model map,HttpSession hs) {
		// Model --- map of model attributes
		System.out.println("show_reg "+hs.getId());
		System.out.println("in show update form " + map+" attr  "+hs.getAttribute("valid_cust")+" "+hs.isNew());
		// get validated user dtls from session scope
		// add it model atter map
		// Model API --- public void addAttribute(String attrName,Object val);
		map.addAttribute("custModel",hs.getAttribute("valid_cust"));
		System.out.println("after map "+map);
		return "update";
	}

	// method for processing update form
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processLoginForm(
			@Valid @ModelAttribute("custModel") Customer c, BindingResult res,
			Model map, HttpSession hs) {
		System.out.println("in process update form " + c);
		try {
			// invoke service layer method for updation
			hs.setAttribute("valid_cust", service.updateCustomer(c));
			map.addAttribute("status", "Updated Successfully");
			return "valid";
		} catch (Exception e) {
				res.rejectValue("email","code",e.getMessage());
				return "update";
		}
		
	}

}
