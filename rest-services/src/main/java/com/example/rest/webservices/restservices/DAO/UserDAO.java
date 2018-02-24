package com.example.rest.webservices.restservices.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.webservices.restservices.Entity.User;
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
