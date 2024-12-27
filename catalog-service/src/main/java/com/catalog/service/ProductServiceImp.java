package com.catalog.service;


import com.catalog.model.Product;
import com.catalog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Service
public class ProductServiceImp implements ProductService{


    private ProductRepository productRepository;

   // private  InventoryClient inventoryClient;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> get() {
        return productRepository.findAll();

    }

    @Override
    public Product get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product data not found"));
    }

   /* @Override
    public List<Product> getProductOfInventory(Long inventoryId) {
        return productRepository.findByProductId(inventoryId);
    }*/
}

