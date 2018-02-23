package com.example.rest.webservices.restservices.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.webservices.restservices.Entity.User;
import com.example.rest.webservices.restservices.Service.UserService;
import com.example.rest.webservices.restservices.Utilities.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User user =userService.findOne(id);
		if(user==null){
			throw new UserNotFoundException("id->" + id);
		}
		else{
			return user;
		}
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser=userService.save(user);
		URI location =ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		User user= userService.deleteById(id);
		if(user==null){
			throw new UserNotFoundException("id->"+id);
		}
		return  ResponseEntity.noContent().build();
	}
}
