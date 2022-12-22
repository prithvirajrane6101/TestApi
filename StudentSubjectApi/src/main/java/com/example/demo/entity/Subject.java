package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subId;
	private String subjectName;
	private int marks;
	
	public Subject() {
		
	}
	
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Subject(int subId, String subjectName, int marks) {
		super();
		this.subId = subId;
		this.subjectName = subjectName;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subjectName=" + subjectName + ", marks=" + marks + "]";
	}
	
	

}
