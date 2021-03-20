package com.udemy28001;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.helloworld.HelloBean;



@RestController
public class HelloWorldController {

	
	@Autowired
	private MessageSource messageSource;
	
	
	// GET
	// URI
	// Method
	@GetMapping("/hello")
	public String helloWorld() {

		return "Hello World-001";

	}

	// hello world bean
	@GetMapping("/hellobean")
	public HelloBean helloBean() {
		return new HelloBean("Hello Bean");
	}

	@GetMapping("/hellobean/{name}")
	public HelloBean helloBeanName(@PathVariable String name) {
		return new HelloBean(String.format("Hello my Friend, %s", name));
	}
	
	@GetMapping("/hellobeanint")
	public String helloBeanInt(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null,locale);
	}
	// below is for not to use hardcode but ContextHolder
//	@GetMapping("/hellobeanint")
//	public String helloBeanInt(@RequestHeader() Locale locale) {
//		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
//	}
	
	
}