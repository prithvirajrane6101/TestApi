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

import com.example.demo.entity.Subject;
import com.example.demo.service.SubjectService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/SubjectDetails")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/add")
	public ResponseEntity<Subject> add(@RequestBody Subject subject){
		Subject sub = subjectService.add(subject);
		return ResponseEntity.ok().body(sub);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id")Integer id) {
		subjectService.deleteById(id);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Subject>> getAll(){
		List<Subject> subject= subjectService.getAll();
		return ResponseEntity.ok().body(subject);		
	}

}
