package com.hcl.training.service;


import java.util.List;

import com.hcl.training.dto.EnrollCourse;
import com.hcl.training.model.UserCourse;

public interface UserCourseService {
	
	public String enrollCourses(EnrollCourse enrollCourse) ;
	
	public List<UserCourse> findUserCourseByuserId(Long userId);
	
	

}
