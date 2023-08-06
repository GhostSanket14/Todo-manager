package com.firstSpringBootProject.myTODOwebApplication.hello;

import org.springframework.web.bind.annotation.RequestMapping;


public class sayHelloController {
	@RequestMapping("/say-hello-using-jsp")
	public String sayHelloJSP() {
		return "helloWorld";
	}
}