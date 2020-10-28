package com.jpa.hibernate.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE", 
	joinColumns = @JoinColumn(name="STUDENT_ID"), 
	inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
	private List<Course> courses = new ArrayList<>();
	
	public Student() {
		super();
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}
	
	public void removeCourses(Course course) {
		this.courses.remove(course);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
