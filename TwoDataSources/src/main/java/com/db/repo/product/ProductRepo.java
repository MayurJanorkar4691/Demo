package com.db.repo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
