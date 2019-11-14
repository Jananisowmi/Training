package com.hcl.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.exception.CourseNotPresentException;
import com.hcl.training.model.Course;
import com.hcl.training.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findCourseByCourseId(Long courseId) {
		Course course=courseRepository.findCourseByCourseId(courseId);
		return course;

	}

	@Override
	public List<Course> findCourseByCourseName(String courseName) throws  CourseNotPresentException  {
		List<Course> courses=courseRepository.findAll();
		List<Course> courseByName=new ArrayList<>();
		for (Course course : courses) {
			courseByName.add(course);
			}
		courseByName=courseByName.stream().filter
				(coursesByName -> coursesByName.getCourseName().toLowerCase().startsWith(courseName.toLowerCase())).collect(Collectors.toList());
		if(courseByName.isEmpty()) {
			throw new CourseNotPresentException("Course not found");
	}
		
		return courseByName;
	}

}
