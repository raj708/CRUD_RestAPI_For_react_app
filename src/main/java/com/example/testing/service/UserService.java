package com.example.testing.service;

import java.util.List;
import java.util.Optional;

import com.example.testing.entity.User;

public interface UserService {

	List<User> findAllUser();

	Optional<User> findById(Long id);


	User saveUser(User user);

	boolean existUser(Long id);

	void deleteUserById(Long id);
	

}
