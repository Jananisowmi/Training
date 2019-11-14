package com.hcl.training.service;

import java.util.List;

import com.hcl.training.dto.LoginRequestDto;
import com.hcl.training.exception.UserNotFoundException;
import com.hcl.training.model.User;
import com.hcl.training.model.UserCourse;

public interface UserService {
	
	public User findUserByUserId(Long userId);

	public List<UserCourse> loginUser(LoginRequestDto loginRequestDto) throws UserNotFoundException;
	


}
