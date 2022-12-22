package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/StudentDetails")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student){
		Student std = studentService.add(student);
		return ResponseEntity.ok().body(std); 
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id")Integer id) {
		studentService.deleteById(id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> student = studentService.getAll();
		return ResponseEntity.ok().body(student);
	}
	
	@GetMapping("/getData/{name}")
	public ResponseEntity<Student> getByName(@PathVariable("name")String name){
		Student student = studentService.getByName(name);
		return ResponseEntity.ok().body(student);
	}

}
