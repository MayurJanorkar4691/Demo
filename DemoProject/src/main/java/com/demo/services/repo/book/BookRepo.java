package com.demo.services.repo.book;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.user.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Integer> {

}
