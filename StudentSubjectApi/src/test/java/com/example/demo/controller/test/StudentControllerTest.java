package com.example.demo.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
public class StudentControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@InjectMocks
	StudentController studentController;
	
	@Mock
	StudentService studentService;
	
	@Test
	void getByNameTest() throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
		Student student =new Student();
		student.setStudentId(1);
		student.setName("viraj");
		student.setAge(24);
		student.setAddress("pune");
		
		Subject subject1=new Subject(1, "maths", 98);
		Subject subject2=new Subject(2, "physics", 85);
		List<Subject> list= new ArrayList();
		list.add(subject1);
		list.add(subject2);
		student.setSubject(list);
		
		String studentObject = objectMapper.writeValueAsString(student);
		
		when(studentService.getByName("prithviraj")).thenReturn(student);
		
		this.mockMvc.perform(post("/StudentDetails/getData/viraj").contentType(MediaType.APPLICATION_JSON).content(studentObject));
	}

}
