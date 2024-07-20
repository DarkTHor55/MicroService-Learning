package com.ProductService.Controller;

import com.ProductService.Entity.Product;
import com.ProductService.Repository.ProductRepository;
import com.ProductService.Request.ProductRequest;
import com.ProductService.Response.ProductResponse;
import com.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest pro_req){
        ProductResponse productResponse = new ProductResponse();
        Product product = productService.createProduct(pro_req);
        System.out.println(product.getId()+product.getName());
        if (product != null){
            productResponse.setInfo("Product Created Successfully");
            productResponse.setStatus(true);
            return ResponseEntity.ok(productResponse);
        }else{
            productResponse.setInfo("Failed to Create Product");
            productResponse.setStatus(false);
            return ResponseEntity.badRequest().body(productResponse);
        }
    }
    @GetMapping("/all")
    public List<Product> getALlProducts(){
        return  productService.getAllProducts();

    }
}
