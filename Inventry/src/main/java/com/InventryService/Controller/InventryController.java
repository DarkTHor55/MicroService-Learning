package com.InventryService.Controller;

import com.InventryService.Service.InventryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventry")
public class InventryController {
    @Autowired
    private InventryService inventryService;
    @GetMapping("/{sku-code}")
    public boolean isInStock(@PathVariable("sku-code") String skuCode){
       return inventryService.isInStock(skuCode);
    }
}
