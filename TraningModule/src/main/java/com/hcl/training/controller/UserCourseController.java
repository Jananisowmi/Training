package com.hcl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.dto.EnrollCourse;
import com.hcl.training.model.UserCourse;
import com.hcl.training.service.UserCourseService;

@RestController
@RequestMapping("/userCourse")
public class UserCourseController {
	
	@Autowired
	UserCourseService userCourseService;
	
	@PostMapping("/enrolledCourses")
	public ResponseEntity<String> enrollment(@RequestBody EnrollCourse enrollCourse) {
		String enroll=userCourseService.enrollCourses(enrollCourse);
		if(enroll.equals("Course Enrolled")) {
			return new ResponseEntity<String>(enroll, HttpStatus.OK);
		}
		return new ResponseEntity<String>(enroll, HttpStatus.NOT_FOUND);
	}
		
	@PostMapping("/userCourses")
	public ResponseEntity<List<UserCourse>> findUserCourseByuserId(Long userId) {
		List<UserCourse> userCourse=userCourseService.findUserCourseByuserId(userId);
		if(userCourse.isEmpty()) {
			return new ResponseEntity<List<UserCourse>>(userCourse, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserCourse>>(userCourse, HttpStatus.OK);
	}
	}


