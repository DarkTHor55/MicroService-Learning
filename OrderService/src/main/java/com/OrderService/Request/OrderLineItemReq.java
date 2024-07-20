package com.OrderService.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemReq {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
