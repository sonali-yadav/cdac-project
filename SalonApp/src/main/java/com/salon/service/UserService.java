package com.salon.service;

import com.salon.model.User;

public interface UserService {
	
	//add customer
	public int createUser(User c);
	
	//get customer
	public User getUserDetails(Long pk);
	
	//deactivate customer
	public String deactivateUser(Long pk);
	
	//update customer details
	public User updateUserDetails(Long pk, User user);
	
}
