package com.song.jsf.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EducationLevelTest {

	@Test
	public void elementaryTest(){
		Long id = new Long(1);
		Student student = new Student(id, "Pedro",13);
		assertEquals("Elementary", student.getEducationLevel());
	}
	
	@Test
	public void secondaryTest(){
		Long id = new Long(1);
		Student student = new Student(id, "Pedro",17);
		assertEquals("Secondary", student.getEducationLevel());
	}
	
	@Test
	public void higherTest(){
		Long id = new Long(1);
		Student student = new Student(id, "Pedro",23);
		assertEquals("Higher", student.getEducationLevel());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exceptionTest(){
		Long id = new Long(1);
		Student student = new Student(id, "Pedro",12);
	}
}
