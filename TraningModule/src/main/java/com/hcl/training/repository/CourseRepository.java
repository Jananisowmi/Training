package com.hcl.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	public  Course findCourseByCourseId(Long courseId);
	
	
	
	

}
