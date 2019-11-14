package com.hcl.training.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Enroll")
@Getter
@Setter
public class UserCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long enrolledId;
	private String courseName;
	private Long userId;
	private  Long courseId;
	private  String userName;
	
	
	

}
