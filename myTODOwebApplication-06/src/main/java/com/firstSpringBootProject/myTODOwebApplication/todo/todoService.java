package com.firstSpringBootProject.myTODOwebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class todoService {
// id,userName, description, date, doneOrNot

	private static int todoCount=0;
	private static List<todo> todos=new ArrayList<>(); // initilize. ie. new .....
	// To initialize static use static block. 
	static {
		todos.add(new todo(++todoCount,"Ghost","Focus on Family",LocalDate.now().plusYears(1),false));
		todos.add(new todo(++todoCount,"Ghost","Focus on Ghost",LocalDate.now().plusYears(1),false));
		todos.add(new todo(++todoCount,"Ghost","Focus on Bappa",LocalDate.now().plusYears(1),false));

	}
	
	public void addTodo(String userName, String description, LocalDate date, boolean doneOrNot) {
		todo todoObj=new todo(++todoCount, userName, description, date, doneOrNot);
		todos.add(todoObj);
	}
		
	public List<todo> todoList(String userName){ // We want to return todos of user name given.
		Predicate<? super todo> predicateObj=TodoObj -> TodoObj.getUserName().equalsIgnoreCase(userName); // We cant use == as it is a string.
		// Above we are checking if username matches.
		// below we are converting it to a stream and will filter only if username matches. So those who match are converted to a list and returned.
		return todos.stream().filter(predicateObj).toList(); 
	}
	
	public void deleteById(int id) { // IF YOU DONT LIKE FUNCTIONAL, YOU CAN USE NORMAL PROGRAMMING ALSO.
		
		// " Predicate<? super todo> predicateObj=TodoObj " <- Here we made a predicate object of our class.
		// " TodoObj -> TodoObj.getId()== id; " <- This like checks every getId in our class (Similar to a loop). And compare it with id
		// Basically we made a predicate object, which has all values of that class. which will be compared.
		Predicate<? super todo> predicateObj=TodoObj -> TodoObj.getId()== id;
		
		todos.removeIf(predicateObj); // RemoveIf() will remove the predicate only if above condition matches.
	}

	public todo findById(int id) {
		Predicate<? super todo> predicateObj=TodoObj -> TodoObj.getId()== id;
		
		// Get a stream/all values from todo, then filter it to those who match predicateObj and from that get first.
		todo TodoObj=todos.stream().filter(predicateObj).findFirst().get(); // We want to return the todo we found.
		return TodoObj;
	}

	public void updateTodo(todo Todo) {
		deleteById(Todo.getId());
		todos.add(Todo);
	}
}