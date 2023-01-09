package com.backendlearn.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backendlearn.entity.Users;
import com.backendlearn.repository.Usersrepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	Usersrepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		//Users users = userRepo.findbyuser_name("siddarth").orElseThrow();
          Users users=userRepo.findByname(username).orElseThrow();
		return users;
	}

}
