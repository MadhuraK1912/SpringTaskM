package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TodoTask;
import com.example.demo.service.TaskService;

@RestController
@CrossOrigin("*")
public class TaskController {
	
	@Autowired
	TaskService taskser;
	
	@GetMapping("getall")
	public List<TodoTask> getAll(){
		return taskser.getAll();
	}
	
	@PostMapping("insert")
	public TodoTask insert(@RequestBody TodoTask t) {
		return taskser.insert(t);
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable int id) {
		taskser.delete(id);
	}
	
	@PutMapping("update")
	public TodoTask update(@RequestBody TodoTask t) {
		return taskser.update(t);
	}
}
