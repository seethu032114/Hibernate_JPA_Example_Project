package com.jpa.hibernate.example.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.example.entity.Passport;
import com.jpa.hibernate.example.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	private EntityManager em;
	
	public Student findById(int id) {
		return em.find(Student.class, id);
	}
	
	public Student save(Student student) {
		if(student.getId()==0) {
			em.persist(student);
		}else {
			em.merge(student);
		}
		return student;
	}
	
	public void deleteById(int id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z12345");
		em.persist(passport);
		Student student = new Student("Jhonny");
		student.setPassport(passport);
		em.persist(student);
	}

}
