package com.inventory.service;

import com.inventory.model.InvetoryProduct;

import java.util.List;

public interface InventoryService {
    InvetoryProduct add(InvetoryProduct product);

    List<InvetoryProduct> get();

    InvetoryProduct get(Long id);
}
