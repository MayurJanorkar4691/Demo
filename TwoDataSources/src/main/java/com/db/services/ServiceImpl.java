package com.db.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.entity.Product;
import com.db.entity.User;
import com.db.repo.product.ProductRepo;
import com.db.repo.user.UserRepo;
@Service
public class ServiceImpl implements ServiceInter {
@Autowired
private UserRepo ur;
@Autowired
private ProductRepo pr;
	@Override
	public void saveUser(User user) {
		ur.save(user);
	}
	@Override
	public void saveProduct(Product product) {
		pr.save(product);
	}
	@Override
	public Optional<User> getUser(Integer id) {
		Optional<User> user = ur.findById(id);
		return user;
	}
	
	

}
