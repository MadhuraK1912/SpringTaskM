package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TodoTask;

public interface TaskService {
	
	public List<TodoTask> getAll();
	
	public TodoTask insert(TodoTask t);
	
	public void delete(int id);
	
	public TodoTask update(TodoTask t);
}
