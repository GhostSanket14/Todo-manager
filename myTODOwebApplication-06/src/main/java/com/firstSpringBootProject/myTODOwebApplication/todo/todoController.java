package com.firstSpringBootProject.myTODOwebApplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("User_Name")
public class todoController {

	private todoService todoServiceObj;
	public todoController(todoService todoServiceObj) {
		super();
		this.todoServiceObj = todoServiceObj;
	}


	@RequestMapping("list-todo")
	public String listTodo(ModelMap mmobj) {
		String userName=(String) mmobj.get("User_Name"); 
		List<todo> todos=todoServiceObj.todoList(userName); // We made a change here. Lec 114
		mmobj.addAttribute("Todos",todos);
		
		return "listTodosJSP";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap mmobj) {
		todo Todo=new todo(0,(String)mmobj.get("User_Name"),"",LocalDate.now().plusYears(1), false);
		mmobj.put("Todo", Todo); 
		return "AddNewTodoPageJSP";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap mmobj, @Valid @ModelAttribute("Todo") todo Todo, BindingResult bresult)
	{
		if(bresult.hasErrors()) {
			return "AddNewTodoPageJSP";
		}
		todoServiceObj.addTodo((String)mmobj.get("User_Name"),Todo.getDescription(),Todo.getDate(), false);
	
		return "redirect:list-todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) { // the id we will get from JSP/URL is what we will use to delete a Todo.
		todoServiceObj.deleteById(id);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpateTodo(@RequestParam int id, ModelMap mmobj) {
		todo TodoObj=todoServiceObj.findById(id);
		mmobj.addAttribute("Todo", TodoObj);
		return "AddNewTodoPageJSP";
	}				
	

	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap mmobj, @Valid @ModelAttribute("Todo") todo Todo, BindingResult bresult)
	{
		if(bresult.hasErrors()) {
			return "AddNewTodoPageJSP";
		}
		String username=getLoggedInUserName(mmobj); // This helps us to get name of current logged in user.
		Todo.setUserName(username); // We are giving values to addNewTodoJSP form. To repopulate it.
		todoServiceObj.updateTodo(Todo);
	return "redirect:list-todo";
}
	private String getLoggedInUserName(ModelMap mmobj) { // So we want to get the user from spring security.
		Authentication authenticationObj=SecurityContextHolder.getContext().getAuthentication();
		
		return authenticationObj.getName(); // This is basically same method as one in welcome controller.
	}
}