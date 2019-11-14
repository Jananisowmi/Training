package com.hcl.training.service;

import java.util.List;

import com.hcl.training.exception.CourseNotPresentException;
import com.hcl.training.model.Course;

public interface CourseService {
	
	 List<Course> findAll();

	 Course findCourseByCourseId(Long courseId) ;

	public List<Course> findCourseByCourseName(String courseName) throws CourseNotPresentException;
	

}
