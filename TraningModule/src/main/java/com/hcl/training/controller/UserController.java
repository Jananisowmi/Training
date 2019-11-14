package com.hcl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.dto.LoginRequestDto;
import com.hcl.training.exception.UserNotFoundException;
import com.hcl.training.model.UserCourse;
import com.hcl.training.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/loginUser")
    public ResponseEntity<List<UserCourse>> loginUser(@RequestBody LoginRequestDto loginRequestDto) throws UserNotFoundException {
		List<UserCourse> userCourse=userService.loginUser(loginRequestDto);
		return new ResponseEntity<List<UserCourse>>(userCourse, HttpStatus.OK);
		
	}

}
