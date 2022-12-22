package com.example.demo.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
public class StudentServiceTest {
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentRepository studentRepository;
	
	@Test
	void getByNameTest() {
		Student student =new Student();
		student.setStudentId(1);
		student.setName("prithviraj");
		student.setAge(24);
		student.setAddress("pune");
		
		Subject subject1=new Subject(1, "maths", 98);
		Subject subject2=new Subject(2, "physics", 85);
		List<Subject> list= new ArrayList();
		list.add(subject1);
		list.add(subject2);
		student.setSubject(list);
		
		when(studentRepository.getByName("prithviraj")).thenReturn(student);
		assertEquals(student, studentRepository.getByName("prithviraj") );
	}

}
