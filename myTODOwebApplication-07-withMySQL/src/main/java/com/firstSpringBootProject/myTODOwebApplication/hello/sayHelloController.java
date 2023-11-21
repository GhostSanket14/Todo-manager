package com.firstSpringBootProject.myTODOwebApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sayHelloController {
	@RequestMapping("/")
	public String sayHelloJSP() {
		return "helloWorld";
	}
}