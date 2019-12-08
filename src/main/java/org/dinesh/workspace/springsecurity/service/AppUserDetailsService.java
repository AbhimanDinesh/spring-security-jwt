package org.dinesh.workspace.springsecurity.service;

import java.util.Arrays;

import org.dinesh.workspace.springsecurity.models.AppUserDetails;
import org.dinesh.workspace.springsecurity.models.User;
import org.dinesh.workspace.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

	/*UserRepo userRepo;

	@Autowired
	public AppUserDetailsService(UserRepo userRepo) {
		
		userRepo.save(new User("dinesh", Arrays.asList("ROLE_USER")));
		userRepo.save(new User("abhiman", Arrays.asList("ROLE_ADMIN")));
		 
	}*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return new AppUserDetails(userRepo.findByUserame(username));
		return new AppUserDetails(new User("abhiman", Arrays.asList("ROLE_ADMIN")));
	}

}
