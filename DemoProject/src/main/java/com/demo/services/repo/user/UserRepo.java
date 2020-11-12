package com.demo.services.repo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.user.User;
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

}
