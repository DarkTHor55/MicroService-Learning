package com.InventryService.Service;

import com.InventryService.Repository.InventryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventryService {
    private InventryRepository inventryRepository;
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventryRepository.findBySkuCode(skuCode).isPresent();
    }
}
