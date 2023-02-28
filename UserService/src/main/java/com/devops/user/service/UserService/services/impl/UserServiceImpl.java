package com.devops.user.service.UserService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.user.service.UserService.entities.User;
import com.devops.user.service.UserService.exceptions.ResourceNotFoundException;
import com.devops.user.service.UserService.repositories.UserRepository;
import com.devops.user.service.UserService.services.UserService;

@Service 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId= UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id not found on the server"+userId));
	}

	@Override
	public User delUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
