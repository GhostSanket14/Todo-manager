package com.firstSpringBootProject.myTODOwebApplication.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.Size;

@Entity
public class todo {

	public todo() {
		
	}

	@Id
	@GeneratedValue // Generate using a sequence
	private int Id;
	private String userName;
	
	@Size(min=10, message="Enter mininum 10 characters") // We added validation in bean. 
	private String description;	// Error msg is shown in both Webpage and console.
	private LocalDate date;
	private boolean doneOrNot;

	public todo(int id, String userName, String description, LocalDate date, boolean doneOrNot) {
		super();
		Id = id;
		this.userName = userName;
		this.description = description;
		this.date = date;
		this.doneOrNot = doneOrNot;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isDoneOrNot() {
		return doneOrNot;
	}

	public void setDoneOrNot(boolean doneOrNot) {
		this.doneOrNot = doneOrNot;
	}

	@Override
	public String toString() {
		return "todo [Id=" + Id + ", userName=" + userName + ", description=" + description + ", date=" + date
				+ ", doneOrNot=" + doneOrNot + ", getId()=" + getId() + ", getUserName()=" + getUserName()
				+ ", getDescription()=" + getDescription() + ", getDate()=" + getDate() + ", isDoneOrNot()="
				+ isDoneOrNot() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}