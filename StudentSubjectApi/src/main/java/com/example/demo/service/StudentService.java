package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Async("asyncExecution")
	public Student add(Student student) {
		return studentRepository.save(student);
	}
	
	@Async("asyncExecution")
	public boolean deleteById(int id) {
		studentRepository.deleteById(id);
		return true;
	}
	
	@Async("asyncExecution")
	public List<Student> getAll(){
		return studentRepository.findAll();	
	}
	
	@Async("asyncExecution")
	public Student getByName(String name) {
		Student student = studentRepository.getByName(name);
		return student;
	}

}
