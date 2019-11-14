package com.hcl.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.model.UserCourse;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

	List<UserCourse> findUserCourseByUserId(Long userId);
	
	UserCourse findUserCourseByUserIdAndCourseId(Long userId,Long courseId);
	
	


	
	

}
