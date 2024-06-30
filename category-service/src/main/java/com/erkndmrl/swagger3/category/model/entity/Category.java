package com.erkndmrl.swagger3.category.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Category")
public class Category {
    @Id
    private String id;
    private String name;
}
