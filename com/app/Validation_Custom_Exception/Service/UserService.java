package com.app.Validation_Custom_Exception.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Validation_Custom_Exception.Entity.User;
import com.app.Validation_Custom_Exception.Exception.UserNotFoundException;
import com.app.Validation_Custom_Exception.Repository.UserRepository;
import com.app.Validation_Custom_Exception.dto.UserRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setAge(userRequest.getAge());
		user.setGender(userRequest.getGender());
		user.setMob(userRequest.getMob());
		user.setNationality(userRequest.getNationality());
		return userRepository.save(user);
	}
	
	public User getUser(Long id) throws UserNotFoundException {
		User user = userRepository.findByUserId(id);	
			if (user!=null) {
				return user;
			}else {
				throw new UserNotFoundException("User Not Found with id : "+id);
			}
	
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();	
	}
}
