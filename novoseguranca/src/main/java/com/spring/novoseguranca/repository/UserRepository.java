package com.spring.novoseguranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.novoseguranca.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	 User findByUsername(String username);

}
