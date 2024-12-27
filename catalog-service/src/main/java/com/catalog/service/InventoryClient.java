/*
package com.catalog.service;


import com.catalog.model.InvetoryProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url="http://localhost:9595", value = "Inventory-Client")
public interface InventoryClient {



    @GetMapping("/api/inventory/{id}")
    List<InvetoryProduct> getInventoryData(@PathVariable Long id);
}
*/
