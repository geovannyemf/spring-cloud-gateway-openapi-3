package com.erkndmrl.swagger3.product.controller;

import com.erkndmrl.swagger3.product.model.entity.Product;
import com.erkndmrl.swagger3.product.model.request.ProductDTO;
import com.erkndmrl.swagger3.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/v1")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get all products", description = "Returns all the products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Get a product by id", description = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @Operation(summary = "Create a product", description = "Create a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created product", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "400", description = "Bad Request - The product was not created", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @Operation(summary = "Delete a product by id", description = "Returns deleted product id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Not found - The product was not found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product id: " + id + " deleted successfully!");
    }
}
