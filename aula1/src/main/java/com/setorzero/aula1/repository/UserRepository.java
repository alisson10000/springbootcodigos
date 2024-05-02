package com.setorzero.aula1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setorzero.aula1.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
