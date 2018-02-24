package com.example.rest.webservices.restservices.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.webservices.restservices.DAO.UserDAO;
import com.example.rest.webservices.restservices.Entity.User;


@Component
public class UserService {
	@Autowired
	private UserDAO userDAO;
	private static List<User> users = new ArrayList<>();
	static{
		users.add(new User(1,"Jon", new Date()));
		users.add(new User(2,"Danerys", new Date()));
		users.add(new User(3,"Tyrion", new Date()));
	}
	private static int userCount=3;
	
	public List<User> findAll(){
		return userDAO.findAll();
	}
	
	public User save(User user){
		
		userDAO.save(user);
		return user;
	}
	
	public User findOne(int id){
		User user= userDAO.findOne(id);
		if(user!=null){
			return user;
		}
		return null;
	}
	
	public void deleteById(int id){
		userDAO.delete(id);
	}
	
}
