package com.catalog.controller;




import com.catalog.model.Product;
import com.catalog.service.ProductService;
import com.catalog.service.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.get();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        return productService.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    /*@GetMapping("/inventory/{inventoryId}")
    public List<Product> getInvetoryProduct(@PathVariable Long inventoryId)
    {
        return productService.getProductOfInventory(inventoryId);
    }*/
}

