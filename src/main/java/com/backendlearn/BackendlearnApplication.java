package com.backendlearn;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.backendlearn.dto.UsersDto;
import com.backendlearn.entity.Users;
import com.backendlearn.helper.UsersHelper;



@SpringBootApplication
public class BackendlearnApplication  implements CommandLineRunner{
	
	
	@Autowired
	PasswordEncoder pass;

	
	
	public static void main(String[] args) {
		SpringApplication.run(BackendlearnApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public UsersHelper userssaveHelper() {
		return new UsersHelper();
	}

	@Bean
	public UsersDto usersDto() {
		return new UsersDto();
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("i runned man");
//		
//		PasswordEncoder passw=PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		System.out.println("first hash"+passw.encode("Password"));
//		
//		String hash=pass.encode("Password");
//		System.out.println("ukpasss"+hash);
//		
//		UserDetails user=User.withDefaultPasswordEncoder().username("ram").password("password").roles("admin").build();
//		System.out.println(user.getPassword());
//	
//		
//		String idForEncode = "bcrypt";
//		Map encoders = new HashMap<>();
//		encoders.put(idForEncode, new BCryptPasswordEncoder());
////		encoders.put("noop", NoOpPasswordEncoder.getInstance());
////		encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5());
////		encoders.put("pbkdf2@SpringSecurity_v5_8", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
////		encoders.put("scrypt", SCryptPasswordEncoder.defaultsForSpringSecurity_v4_1());
////		encoders.put("scrypt@SpringSecurity_v5_8", SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8());
////		encoders.put("argon2", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2());
////		encoders.put("argon2@SpringSecurity_v5_8", Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8());
//		encoders.put("sha256", new StandardPasswordEncoder());
//
//		PasswordEncoder passwordEncoders =
//		    new MessageDigestPasswordEncoder("MD5");
//		System.out.println(passwordEncoders.encode("Password"));
//
//		
//
//		
		
		

	}

}
