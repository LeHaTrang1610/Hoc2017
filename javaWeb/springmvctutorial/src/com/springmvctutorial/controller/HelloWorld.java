package com.springmvctutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//
@RequestMapping("/")
public class HelloWorld {

	@RequestMapping("welcome")
	public ModelAndView helloWorld() {

		String message = "Hello this is welcome page";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping("Trang")
	public ModelAndView myName() {

		String message1 = "Le Ha Trang";
		String message2 = "Le ";
		ModelAndView mode = new ModelAndView();
		mode.addObject("message1", message1);
		mode.addObject("message2", message2);
		return mode;
		
	}
}
