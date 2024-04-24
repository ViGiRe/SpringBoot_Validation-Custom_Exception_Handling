package com.app.Validation_Custom_Exception.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Validation_Custom_Exception.Entity.User;
import com.app.Validation_Custom_Exception.Exception.UserNotFoundException;
import com.app.Validation_Custom_Exception.Service.UserService;
import com.app.Validation_Custom_Exception.dto.UserRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<User>(userService.saveUser(userRequest), HttpStatus.CREATED);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) throws UserNotFoundException{	
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);	
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<User>> getAllUser(){
		
		return  ResponseEntity.ok(userService.getAllUser());
		
	}
}
