package com.ProductService.Request;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private BigDecimal price;
    @Column(length = 1000)
    private String description;
}
