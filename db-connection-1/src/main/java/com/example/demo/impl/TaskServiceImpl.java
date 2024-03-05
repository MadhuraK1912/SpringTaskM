package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoTask;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskRepository taskrepo;
	
	@Override
	public List<TodoTask> getAll() {
		return taskrepo.findAll();
	}

	@Override
	public TodoTask insert(TodoTask t) {
		return taskrepo.save(t);
	}

	@Override
	public void delete(int id) {
		taskrepo.deleteById(id);
	}

	@Override
	public TodoTask update(TodoTask t) {
		return taskrepo.save(t);
	}
	
}
