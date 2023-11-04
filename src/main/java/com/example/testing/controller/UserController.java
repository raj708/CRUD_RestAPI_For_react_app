package com.example.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing.entity.User;
import com.example.testing.exception.UserNotFoundException;
import com.example.testing.service.UserService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.findAllUser();
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.findById(id).orElseThrow(()->new UserNotFoundException(id));
	}
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@PutMapping("/updateUser/{id}")
	public User editUser(@RequestBody User newUser,@PathVariable Long id) {
		User user=userService.findById(id).orElseThrow(()->new UserNotFoundException(id));
		if(user !=null) {
			user.setName(newUser.getName());
			user.setEmail(newUser.getEmail());
			return userService.saveUser(user);
		}
		else {
			return user;
		}
	}
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id ) {
		if(!userService.existUser(id)) {
			throw new UserNotFoundException(id);
		}
		else {
			userService.deleteUserById(id);
			return "User with id " + id + " has been deleted success.";
		}
	}

}
