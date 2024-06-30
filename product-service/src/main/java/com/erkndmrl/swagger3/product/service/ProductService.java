package com.erkndmrl.swagger3.product.service;

import com.erkndmrl.swagger3.product.model.entity.Product;
import com.erkndmrl.swagger3.product.model.request.ProductDTO;
import com.erkndmrl.swagger3.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow();
    }
    public Product createProduct(ProductDTO productDTO) {
        Product department = new Product();
        department.setName(productDTO.getName());
        return productRepository.save(department);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }


}
