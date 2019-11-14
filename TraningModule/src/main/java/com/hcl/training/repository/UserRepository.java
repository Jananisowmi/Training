package com.hcl.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByUserId(Long userId);
	
//	public User findUserByUserNameAndPassWord(String userName,String passWord);

}
