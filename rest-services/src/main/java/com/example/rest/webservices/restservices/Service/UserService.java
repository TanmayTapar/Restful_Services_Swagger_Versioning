package com.example.rest.webservices.restservices.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rest.webservices.restservices.Entity.User;


@Component
public class UserService {
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
	
	public User deleteById(int id){
		Iterator<User> iterator= users.iterator();
		while(iterator.hasNext()){
			User user= iterator.next();
			if(user.getId()==id){
				iterator.remove();
				return user;
			}
		}
	
		return null;
	}
	
}
