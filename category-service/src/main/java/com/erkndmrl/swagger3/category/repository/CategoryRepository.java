package com.erkndmrl.swagger3.category.repository;

import com.erkndmrl.swagger3.category.model.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
