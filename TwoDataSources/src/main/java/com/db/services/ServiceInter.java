package com.db.services;

import java.util.Optional;

import com.db.entity.Product;
import com.db.entity.User;

public interface ServiceInter {

	void saveUser(User user);

	void saveProduct(Product product);

	Optional<User> getUser(Integer id);

}
