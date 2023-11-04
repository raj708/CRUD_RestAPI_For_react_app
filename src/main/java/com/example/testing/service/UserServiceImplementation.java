package com.example.testing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.entity.User;
import com.example.testing.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAllUser() {	
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public boolean existUser(Long id) {
		
		return userRepository.existsById(id);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

}
