package com.hcl.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.dto.LoginRequestDto;
import com.hcl.training.exception.UserNotFoundException;
import com.hcl.training.model.User;
import com.hcl.training.model.UserCourse;
import com.hcl.training.repository.UserCourseRepository;
import com.hcl.training.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserCourseRepository userCourseRepository;

	@Override
	public User findUserByUserId(Long userId) {
		return userRepository.findUserByUserId(userId);
	}

	@Override
	public List<UserCourse> loginUser(LoginRequestDto loginRequestDto) throws UserNotFoundException {
		User user = userRepository.findUserByUserId(loginRequestDto.getUserId());
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}

		if (loginRequestDto.getUserId() == user.getUserId()
				&& loginRequestDto.getPassWord().equals(user.getPassWord())) {
			List<UserCourse> userCourse = userCourseRepository.findUserCourseByUserId(loginRequestDto.getUserId());
			return userCourse;
		} else {

			return null;
		}
	}
}
