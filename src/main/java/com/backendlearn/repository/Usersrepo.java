package com.backendlearn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendlearn.entity.Users;

@Repository
public interface Usersrepo extends JpaRepository<Users,Integer>{
	
	Optional<Users> findByname(String name);
	

}
