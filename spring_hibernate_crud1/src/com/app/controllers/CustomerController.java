package com.app.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Customer;
import com.app.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	@Qualifier("dao_based_service")
	private CustomerService service;

	// lists all customers
	@RequestMapping("/list")
	public String listCustomers(Model map) {
		List<Customer> l1 = service.listCustomers();
		System.out.println("in list controller " + l1);
		map.addAttribute("cust_list", l1);
		return "list";
	}

	// show form for updating selected customer : pre populated with customer
	// data
	@RequestMapping(value = "/update/{custId}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable int custId, Model map) {
		System.out.println("update controller " + custId);
		// invoke service layer method to get cust details
		map.addAttribute("custModel", service.getDetails(custId));
		return "update";
	}

	// process update form

	@RequestMapping(value = "/update/{custId}", method = RequestMethod.POST)
	public String processUpdateForm(
			@Valid @ModelAttribute("custModel") Customer cust,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr) {
		System.out.println("in process update form " + cust);
		if (res.hasErrors()) {
			System.out.println("update P.L errs ");
			return "update";
		}
		System.out.println("update : no p.l errs");
		try {
			// invoke service layer method for updation
			hs.setAttribute("valid_cust", service.updateCustomer(cust));
			// added flash attribute
			attr.addAttribute("status", "Updated Successfully");
			// redirect after post pattern
			return "redirect:/cust/list";
		} catch (Exception e) {
			res.rejectValue("email", "code", e.getMessage());
			return "update";
		}

		/*
		 * System.out.println("process_update " + cust);
		 * service.updateCustomer(cust); // redirect after post pattern return
		 * "redirect:/cust/list";
		 */
	}

	// un subscribe customer & after redirection take user back to cusotmer list
	@RequestMapping(value = "/delete/{custId}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int custId,
			RedirectAttributes attr) {
		System.out.println("delete controller " + custId);
		// invoke service layer method to delete cust details
		try {
			String sts = service.deleteCustomer(custId);
			attr.addAttribute("status", sts);
		} catch (Exception e) {
			System.out.println("err in delete controller " + e);
			attr.addAttribute("status",
					"Customer unsubscription failed : " + e.getMessage());
		}
		return "redirect:/cust/list";
	}
	// show registration form for new customer : 
	
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public String showRegForm( Model map) {
			System.out.println("show reg form " );
			// invoke service layer method to add cust details
			map.addAttribute("custModel", new Customer());
			return "register";
		}


	// process registration form

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegisterForm(
			@Valid @ModelAttribute("custModel") Customer cust,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr) {
		System.out.println("in process reg form " + cust);
		if (res.hasErrors()) {
			System.out.println("register P.L errs ");
			return "register";
		}
		System.out.println("register : no p.l errs");
		try {
			// invoke service layer method for updation
			hs.setAttribute("valid_cust", service.registerCustomer(cust));
			// added flash attribute
			attr.addAttribute("status", "Registered Successfully");
			// redirect after post pattern -- redirected to cust list page.
			return "redirect:/cust/list";
		} catch (Exception e) {
			res.rejectValue("email", "code", e.getMessage());
			return "register";
		}
	}

}
