package com.catalog.service;


import com.catalog.model.Product;

import java.util.List;

public interface ProductService {

  Product add(Product product);

  List<Product> get();

  Product get(Long id);

  //List<Product> getProductOfInventory(Long inventoryId);

}
