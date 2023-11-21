package com.firstSpringBootProject.myTODOwebApplication.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("User_Name")
public class projectController {

	projectRepo projectRepoObj;

	public projectController(projectRepo projectRepoObj) {
		super();
		this.projectRepoObj = projectRepoObj;
	}
	
	@RequestMapping("/project-planner")
	public String showData(ModelMap mmobj) {
		
		return "projectData";
	}
	
}