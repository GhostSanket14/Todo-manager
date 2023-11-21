package com.firstSpringBootProject.myTODOwebApplication.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class project {
	@Id
	int id;
	String name;
}