package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Async("asyncExecution")
	public Subject add(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@Async("asyncExecution")
	public boolean deleteById(int id) {
		subjectRepository.deleteById(id);
		return true;
	}
	
	@Async("asyncExecution")
	public List<Subject> getAll(){
		return subjectRepository.findAll();
	}

}
