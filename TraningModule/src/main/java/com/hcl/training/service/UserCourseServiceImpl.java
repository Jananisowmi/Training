package com.hcl.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.dto.EnrollCourse;
import com.hcl.training.model.Course;
import com.hcl.training.model.User;
import com.hcl.training.model.UserCourse;
import com.hcl.training.repository.UserCourseRepository;

@Service
public class UserCourseServiceImpl implements UserCourseService {

	@Autowired
	UserCourseRepository userCourseRepository;

	@Autowired
	UserService userService;

	@Autowired
	CourseService courseService;

	@Override
	public String enrollCourses(EnrollCourse enrollCourse) {
		String result = null;
		User user = userService.findUserByUserId(enrollCourse.getUserId());
		Course course = courseService.findCourseByCourseId(enrollCourse.getCourseId());
		UserCourse userCourses=userCourseRepository.findUserCourseByUserIdAndCourseId(enrollCourse.getUserId(), enrollCourse.getCourseId());
		if(userCourses==null) {
		if (enrollCourse.getUserId() != null && enrollCourse.getCourseId() != null) {
			UserCourse userCourse = new UserCourse();
			userCourse.setCourseId(enrollCourse.getCourseId());
			userCourse.setUserId(enrollCourse.getUserId());
			userCourse.setCourseName(course.getCourseName());
			userCourse.setUserName(user.getUserName());
			userCourseRepository.save(userCourse);
			result = "Course Enrolled";
		} else {
			result = "Id not found";
		}
		}else {
			result="User already enrolled this course";
		}
		return result;
	}
	

	@Override
	public List<UserCourse> findUserCourseByuserId(Long userId) {
		List<UserCourse> enrollList=userCourseRepository.findUserCourseByUserId(userId);
		return enrollList;
	}

}
