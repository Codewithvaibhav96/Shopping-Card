package com.inventory.service;



import com.inventory.model.InvetoryProduct;

import com.inventory.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImp implements InventoryService {


    private ProductRepository productRepository;

    public InventoryServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public InvetoryProduct add(InvetoryProduct product) {
        return productRepository.save(product);
    }

    @Override
    public List<InvetoryProduct> get() {
        return productRepository.findAll();
    }

    @Override
    public InvetoryProduct get(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Invetory product not found"));
    }
}
