package com.salon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.exception.ResourceNotfoundException;
import com.salon.model.User;
import com.salon.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository crepo;

	// get customer details
	public User getUserDetails(Long pk) {
		return crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("User", "pk", pk));
	}

	// adding a new customer
	public int createUser(User c) {
		
		//here we will first verify whether this is a new customer
		//only then allow for sign up
		User cust=crepo.findByEmail(c.getEmail());
		if(cust==null) {
			crepo.save(c);
			return 1;
		} else {
			return 0;
		}
	}

	// deactivate a customer
	public String deactivateUser(Long pk) {
		User cust = crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("Customer", "pk", pk));
		cust.setActiveDeactive(0);
		crepo.save(cust);
		return "deactivated";
	}

	// update customer details
	public User updateUserDetails(Long pk, User customer) {
		User cust = crepo.findById(pk).orElseThrow(() -> new ResourceNotfoundException("Customer", "pk", pk));
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setEmail(customer.getEmail());
		cust.setGender(customer.getGender());
		cust.setContact1(customer.getContact1());
		cust.setContact2(customer.getContact2());
		cust.setActiveDeactive(1);

		User c = crepo.save(cust);
		return c;
	}
}
