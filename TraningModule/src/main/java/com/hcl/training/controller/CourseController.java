package com.hcl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.exception.CourseNotPresentException;
import com.hcl.training.model.Course;
import com.hcl.training.service.CourseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {
	
	@Autowired
	CourseService courseService;

	@GetMapping(value = "/listAllCourses")
	public ResponseEntity<List<Course>> listAllCourse() {
		List<Course> course = courseService.findAll();
		log.info("List the All Stocks");
		if (course.isEmpty()) {
			return new ResponseEntity<>(course, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/course/{courseId}")
	public ResponseEntity<Course> getCourseByCourseId(@PathVariable("courseId")Long courseId)   {
		Course course =  courseService.findCourseByCourseId(courseId);
		if (course==null) {
			return new ResponseEntity<Course> (course, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Course> (course, HttpStatus.OK);
	}
	
	@GetMapping(value = "/course/{courseName}")
	public ResponseEntity<List<Course>>  getCourseByCourseName(String courseName) throws CourseNotPresentException {
		List<Course> course =  courseService.findCourseByCourseName(courseName);
		if (course==null) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().body(course);
	}

}
