package com.jpa.hibernate.example.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.example.entity.Course;
import com.jpa.hibernate.example.entity.Review;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	public Course findById(int id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() == 0) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public void deleteById(int id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void addHardCodedReviewForCourse() {
		// get Course
		Course course = findById(1002);
		logger.info("Reviews of 1002 -> {}", course.getReviews());

		// Add Reviews
		Review review1 = new Review("5", "Cool");
		Review review2 = new Review("4", "Okay");

		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		// Save to DB
		em.persist(review1);
		em.persist(review2);

	}

	public void addReviewForCourse(int courseId, List<Review> reviews) {
		// get Course
		Course course = findById(courseId);
		logger.info("Reviews of 1002 -> {}", course.getReviews());

		for (Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}

	}

}
