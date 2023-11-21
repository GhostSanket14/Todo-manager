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

@Controller
@SessionAttributes("User_Name")
public class todoControllerJPA {

	private TodoRepository todoRepoObj; // Here we are now using that interface we created.
	
	public todoControllerJPA(TodoRepository todoRepoObj) { // using this constructor to autowire it in.
		super();
		this.todoRepoObj=todoRepoObj;
	}


	@RequestMapping("list-todo")
	public String listTodo(ModelMap mmobj) {
		String userName=(String) mmobj.get("User_Name"); 
		List<todo> todos=todoRepoObj.findByUserName(userName); // We made a change here. Lec 114
		mmobj.addAttribute("Todos",todos);
		
		return "listTodosJSP";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap mmobj) {
		todo Todo=new todo(0,(String)mmobj.get("User_Name"),"",LocalDate.now().plusYears(1), false);
		mmobj.put("TodoModAt", Todo); 
		return "AddNewTodoPageJSP";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap mmobj, @Valid @ModelAttribute("Todo") todo TodoModAt, BindingResult bresult)
	{
		if(bresult.hasErrors()) {
			return "AddNewTodoPageJSP";
		}
		String username=getLoggedInUserName(mmobj);
		TodoModAt.setUserName(username);
		todoRepoObj.save(TodoModAt);
		
//		todoServiceObj.addTodo((String)mmobj.get("User_Name"),Todo.getDescription(),Todo.getDate(), Todo.isDoneOrNot()); // Here we are now using user entered values.
		// We removed above to add the todoRepo
		return "redirect:list-todo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) { // the id we will get from JSP/URL is what we will use to delete a Todo.
	
		todoRepoObj.deleteById(id);		
//		todoServiceObj.deleteById(id);
		return "redirect:list-todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpateTodo(@RequestParam int id, ModelMap mmobj) {
		todo TodoObj=todoRepoObj.findById(id).get(); // We have to get .get() as well.
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
		todoRepoObj.save(Todo);
		//		todoServiceObj.updateTodo(Todo);
	return "redirect:list-todo";
}
	private String getLoggedInUserName(ModelMap mmobj) { // So we want to get the user from spring security.
		Authentication authenticationObj=SecurityContextHolder.getContext().getAuthentication();
		
		return authenticationObj.getName(); // This is basically same method as one in welcome controller.
	}
}