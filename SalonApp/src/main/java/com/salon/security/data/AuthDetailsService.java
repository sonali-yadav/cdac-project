package com.salon.security.data;


/**
 * This is the service layer for Spring security module.
 * Primarily used to fetch user details from a database.
 * 
 * It overrides the loadUserByUsername for fetching user details from the database using the username.
 * 
 * Load user by username should return a valid username (in our case email),
 * 		without which the JWT token check will fail
 */


import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("vatadepalli@hotmail.com".equals(username)) {
			return new User("vatadepalli@hotmail.com", "$2y$12$zdS8obL2KEjfvrEfUQMmAOt.VxWASbYjz9CTjuwW1qyCJN/WENaVy",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}