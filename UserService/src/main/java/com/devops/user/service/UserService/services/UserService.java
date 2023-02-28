package com.devops.user.service.UserService.services;

import java.util.List;

import com.devops.user.service.UserService.entities.User;

public interface UserService {
	
	User saveUser(User user); //creating user
	
	List<User> getAllUser(); // getting all users
	
	User getUser(String userId); //getting single user from the particular userId
	
	User delUser(String userId); // deleting a user of the given userId
	
}
