package com.ProductService.Service;

import com.ProductService.Entity.Product;
import com.ProductService.Repository.ProductRepository;
import com.ProductService.Request.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private static final Logger log= LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(ProductRequest request) {
        if(request.getName().isEmpty()||request.getDescription().isEmpty()||request.getPrice() == null){
            return  null;
        }
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        productRepository.save(product);
        log.info("Product Saved  with Id "+product.getId());
        return product;

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
