package com.OrderService.Controller;

import com.OrderService.Entity.Order;
import com.OrderService.Request.OrderRequest;
import com.OrderService.Service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public String placeOrder(@RequestBody OrderRequest request) {
        orderService.placeOrder(request);

        return "Order placed successfully";
    }
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
