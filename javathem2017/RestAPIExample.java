package com.springmvctutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvctutorial.model.Person;

@Controller
@RequestMapping("/")
public class RestAPIExample {

	@RequestMapping(value = "getmethod", method = RequestMethod.GET)
	@ResponseBody
	public String getMethod() {
		return "Welcome to GET";
	}

	/*
	 * http://localhost:8080/springmvctutorial/getmethod/Nhut Nguyen
	 */
	@RequestMapping(value = "getmethod/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String getName(@PathVariable String name) {
		return "Hello " + name;
	}

	/*
	 * http://localhost:8080/springmvctutorial/getparam?age=20&year=2015
	 */
	@RequestMapping(value = "getparam", method = RequestMethod.GET)
	@ResponseBody
	public String getName(@RequestParam("age") int age, @RequestParam("year") int year) {
		return "I'm " + age + " and was born " + year;
	}

	@RequestMapping(value = "getjson", method = RequestMethod.GET)
	@ResponseBody
	public Person getJson() {
		Person p = new Person();
		p.setAge(20);
		p.setCity("HCM");
		p.setName("ThanhNhan");
		return p;
	}
	
	@RequestMapping(value = "postjson", method = RequestMethod.POST)
	@ResponseBody
	public Person postJson(@RequestBody Person personJson) {
		return personJson;
	}
}
