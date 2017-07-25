package org.com.cay.controller;

import org.com.cay.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${age}")
	private int age; 
	
	@Value("${name}")
	private String name;
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private Girl girl;
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	//@GetMapping(value = "/hello")
	//简化版，method为get的RequestMapping，还有PostMapping等等...
	public String say(){
		return girl.getName();
	}
}
