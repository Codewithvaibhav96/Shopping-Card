package com.inventory.controller;


import com.inventory.model.InvetoryProduct;
import com.inventory.service.InventoryService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/inventory")
public class InventoryController {


    private InventoryService inventoryService;

    public InventoryController(InventoryService productService) {
        this.inventoryService = productService;
    }

    @GetMapping
    public List<InvetoryProduct> getAllProducts() {
        return inventoryService.get();
    }

    @GetMapping("/{id}")
    public InvetoryProduct getProductById(@PathVariable Long id) {

        return inventoryService.get(id);
    }

    @PostMapping
    public ResponseEntity<InvetoryProduct> createProduct(@RequestBody InvetoryProduct product) {
        InvetoryProduct savedProduct = inventoryService.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }


}

