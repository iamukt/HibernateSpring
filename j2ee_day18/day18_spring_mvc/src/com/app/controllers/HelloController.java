package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //mandatory
@RequestMapping("/test") //optional
public class HelloController {

	public HelloController() {
		System.out.println("in constr : hello controller");
	}
	//req handling method
	@RequestMapping(value="/hello") //mandatory
	public String sayHello()
	{
		System.out.println("in say hello");
		return "welcome";//logical view name
	}

}
