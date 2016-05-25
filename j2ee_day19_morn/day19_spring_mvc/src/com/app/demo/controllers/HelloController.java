package com.app.demo.controllers;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class HelloController {

	public HelloController() {
		System.out.println("in constr");
	}

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("in say hello");
		return "welcome";// logical view name
	}

	@RequestMapping("/hello2")
	public ModelAndView sayHello2() {
		System.out.println("in say hello2");
		// ModelAndView(String logViewName,String modelAttrName,Object
		// modelAttrVal)
		return new ModelAndView("welcome", "curnt_date", 
				new Date());
	}
	@RequestMapping("/hello3")
	public String sayHello3(Model map) {
		System.out.println("in say hello3 "+map);
		//Model --- o.s.ui. --- i/f
		//Model i/f --represents map of model attrs.
		map.addAttribute("curnt_date",new Date());
		map.addAttribute("num_list",Arrays.asList(20,34,45));
		System.out.println("in say hello3 again "+map);
		return "welcome";
	}

}
