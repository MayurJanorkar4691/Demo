package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.user.Book;
import com.demo.model.user.User;
import com.demo.services.repo.book.BookRepo;
import com.demo.services.repo.user.UserRepo;


@Service
public class DemoService implements ServicesList {
    @Autowired
	private UserRepo ur;
    
    @Autowired
    private BookRepo br;
    
	@Override
	public void saveUser(User user) {
		ur.save(user);
	}
	@Override
	public void saveBook(Book book) {
		br.save(book);
	}

}
