package com.jpa.hibernate.example.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.example.entity.Passport;
import com.jpa.hibernate.example.entity.Student;

@SpringBootTest
class StudentRepositoryTests {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 2001);
		logger.info("Student info : {}", student);
		logger.info("Passport info : {}", student.getPassport());
	}
	
	
	@Test
	@Transactional
	public void retrieveStudentDetailsAssociatedToPassport() {
		Passport passport = em.find(Passport.class, 3001);
		logger.info("Passport info : {}", passport);
		logger.info("Student info : {}", passport.getStudent());
	}
	
}
