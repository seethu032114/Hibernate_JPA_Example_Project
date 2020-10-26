package com.jpa.hibernate.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.hibernate.example.entity.Course;

@SpringBootTest
class CourseRepositoryTests {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;

	@Test
	public void findById_BasicTest() {
		Course course = repository.findById(1002);
		assertEquals("Java in 100 steps", course.getName());
	}

	@Test
	public void deleteById_BasicTest() {
		repository.deleteById(1002);
		assertNull(repository.findById(1002));
	}
	
	@Test
	public void save_Test() {
		Course course = repository.findById(1002);
		assertEquals("Java in 100 steps", course.getName());
		
		course.setName("Java in 100 steps - Updated");
		repository.save(course);
		
		Course course1 = repository.findById(1002);
		assertEquals("Java in 100 steps - Updated", course1.getName());
		
	
	}
}
