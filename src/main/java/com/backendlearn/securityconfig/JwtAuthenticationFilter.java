package com.backendlearn.securityconfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	UserDetailsService userDetailService;

	@Autowired
	JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader("Authorization");

		// bearer dlfa6464

		
		

		String userName = null;
		String password = null;
		String requestToken=null;

		if (request != null && token.startsWith("bearer")) {
			requestToken=token.substring(7);
			try {

				
				userName = jwtTokenHelper.getUsernameFromToken(requestToken);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (ExpiredJwtException e) {
				System.out.println(e.getMessage());
			} catch (MalformedJwtException e) {
				System.out.println(e.getMessage());
			}

		} else {

			System.out.println("Either token is null or in invalid format");
		}

		// after getting token validate

//		JsonObject json= new Gson().fromJson(userName,JsonObject.class);
//		System.out.println(json.getAsString());

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailService.loadUserByUsername(userName);

			// validating tokens here
			if (jwtTokenHelper.validateToken(requestToken, userDetails)) {

				/// now authenticate user

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("invalid jwt token");
			}

		} else {
			System.out.println("username is null or security context is taken");
		}
		filterChain.doFilter(request, response);
	}

}
