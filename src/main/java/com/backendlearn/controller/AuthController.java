package com.backendlearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendlearn.dto.JwtAuthDto;
import com.backendlearn.payloads.JwtAuthResponse;
import com.backendlearn.securityconfig.JwtTokenHelper;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	JwtTokenHelper jwtTokenHelper;

	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/getauthenticate")
	public JwtAuthResponse getToken(@RequestBody JwtAuthDto jwtAuthDto) {
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();

		this.authenticate(jwtAuthDto.getUsername(), jwtAuthDto.getPassword());
		UserDetails userDetails = userDetailService.loadUserByUsername(jwtAuthDto.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);

		String username=jwtTokenHelper.getUsernameFromToken(token);
		
		System.out.println(username);
		System.out.println(jwtTokenHelper.getExpirationDateFromToken(token));
		System.out.println(token);
		jwtAuthResponse.setToken(token);
		return jwtAuthResponse;
	}

	private void authenticate(String userName, String password) {

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password);

		try {
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		} catch (DisabledException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
