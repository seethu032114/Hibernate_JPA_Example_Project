package com.jpa.hibernate.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.example.entity.Course;
import com.jpa.hibernate.example.repository.CourseRepository;
import com.jpa.hibernate.example.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Course course=repository.findById(1001);
//		logger.info("Course 1001: {}" , course);
//		
//		repository.save(new Course("MicroServices in 100 steps"));
		
//		repository.deleteById(1002);
		
		studentRepository.saveStudentWithPassport();
		
	}

}
