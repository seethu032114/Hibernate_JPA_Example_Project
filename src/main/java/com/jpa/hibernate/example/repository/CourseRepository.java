package com.jpa.hibernate.example.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.example.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	private EntityManager em;
	
	public Course findById(int id) {
		return em.find(Course.class, id);
	}
	
	public Course save(Course course) {
		if(course.getId()==0) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(int id) {
		Course course = findById(id);
		em.remove(course);
	}

}
