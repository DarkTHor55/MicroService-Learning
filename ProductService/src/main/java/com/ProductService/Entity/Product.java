package com.ProductService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Column(length = 1000)
    private String description;
}
