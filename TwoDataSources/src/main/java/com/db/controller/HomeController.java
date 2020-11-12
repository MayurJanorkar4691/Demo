package com.db.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.entity.Product;
import com.db.entity.User;
import com.db.exceptions.UserNotFound;
import com.db.services.ServiceInter;
@RequestMapping("/db")
@RestController
public class HomeController {
	
	@Autowired
	private ServiceInter si;
	@PostMapping("/add/user")
	public ResponseEntity<String> addUser(@RequestBody User user)
			{
			      si.saveUser(user);
			      return new ResponseEntity<String>("User added Successfully ", HttpStatus.CREATED);
			}
    @PostMapping("/add/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product)
    {
	   si.saveProduct(product);
	   return new ResponseEntity<String>("Product added Successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get/user/{uId}")
    public ResponseEntity<Object> getUser(@PathVariable("uId") Integer id) throws UserNotFound
    {
    	Optional<User> user = si.getUser(id);
    	if(user.isPresent())
    	{
    		return new ResponseEntity<Object>(user, HttpStatus.ACCEPTED);
    	}
    	else {
    		throw new UserNotFound("id "+id);
    	}
    }
	
	
	
	

}
