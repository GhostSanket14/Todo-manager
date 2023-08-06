package com.firstSpringBootProject.myTODOwebApplication.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("User_Name") // put here variable caught by requestparam.
public class welcomeController {

	@RequestMapping(value="/", method=RequestMethod.GET) // Basically / will take us to welcome.
	public String welocomePage(ModelMap mmobj) { // For new we are just hard coding.
		mmobj.put("User_Name",getloggedInUser());
		return "WelcomeUser";
	}
	
	private String getloggedInUser() { // make sure to import spring.security.core packages for these.
		Authentication authenticationObj=SecurityContextHolder.getContext().getAuthentication();
		
		return authenticationObj.getName(); 
	}
	
}