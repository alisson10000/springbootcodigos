package com.setorzero.aula1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.setorzero.aula1.dto.UserDTO;
import com.setorzero.aula1.entities.User;
import com.setorzero.aula1.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO findById(Long id) {

		User entity = userRepository.findById(id).get();

		UserDTO userDTO = new UserDTO(entity);

		return userDTO;

	}

}
