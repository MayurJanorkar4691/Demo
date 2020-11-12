package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.user.Book;
import com.demo.model.user.User;
import com.demo.services.ServicesList;
@RequestMapping("/demo")
@RestController
public class DemoController {
	@Autowired
	private ServicesList sl ;
	
	@PostMapping("/add/user")
	public ResponseEntity<String> addUser(@RequestBody User user)

	{
		sl.saveUser(user);
	return new ResponseEntity<String>("User is saved", HttpStatus.CREATED);
	
	}
	
	@PostMapping("/add/book")
	public ResponseEntity<String> addBook(@RequestBody Book book)

	{
		sl.saveBook(book);
	return new ResponseEntity<String>("Book is saved", HttpStatus.CREATED);
	
	}
	
	
}
