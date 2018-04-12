package com.song.jsf.example;

import java.io.Serializable;


public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private int age;
	private String educationLevel;
	
	public Student() {}
	public Student(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age=age;
		setEducationLevel(age);
	}

	public void setEducationLevel(int age) throws IllegalArgumentException {
		if(age>12 && age<=16) {educationLevel="Elementary"; return;}
		if(age>16 && age<=22) {educationLevel="Secondary"; return;}
		if(age>22) {educationLevel="Higher"; return;}
		throw new IllegalArgumentException("Age must be higher or equal to 13");
		
	}
	
	public String getEducationLevel() { return educationLevel; }

	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { 
		this.age = age;
		setEducationLevel(age);
	}
	@Override
	public Student clone() {
		return new Student(id, name, age);
	}

	public void restore(Student student) {
		this.id = student.getId();
		this.name = student.getName();
	}
}
