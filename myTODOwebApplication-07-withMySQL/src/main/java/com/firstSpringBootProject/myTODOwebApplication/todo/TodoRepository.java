package com.firstSpringBootProject.myTODOwebApplication.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<todo, Integer>{
	public List<todo> findByUserName(String username); // This will automatically search b user name.
}