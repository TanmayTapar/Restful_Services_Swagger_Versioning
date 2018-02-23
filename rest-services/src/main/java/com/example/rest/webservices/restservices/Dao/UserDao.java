package com.example.rest.webservices.restservices.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import com.example.rest.webservices.restservices.entity.User;
@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	static{
		users.add(new User(1,"Jon", new Date()));
		users.add(new User(2,"Danerys", new Date()));
		users.add(new User(3,"Tyrion", new Date()));
	}
	private static int userCount=3;
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		if(user.getId()== null){
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
}
