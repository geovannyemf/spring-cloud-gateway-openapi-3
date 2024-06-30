package com.erkndmrl.swagger3.product.repository;

import com.erkndmrl.swagger3.product.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
