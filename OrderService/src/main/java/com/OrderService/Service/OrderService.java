package com.OrderService.Service;

import com.OrderService.Entity.Order;
import com.OrderService.Entity.OrderLineItems;
import com.OrderService.Repository.OrderRepository;
import com.OrderService.Request.OrderLineItemReq;
import com.OrderService.Request.OrderRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order placeOrder(OrderRequest order) {
        Order order1 = new Order();
        order1.setOrderNumner(UUID.randomUUID().toString());
        order1.setOrderLineItems(order.getOrderLineItems().stream().map(orderLineItems->mapToDto(orderLineItems)).toList());
        orderRepository.save(order1);
        return order1;
    }

    private OrderLineItems mapToDto(OrderLineItemReq orderLineItems) {

        OrderLineItems orderLineItems1 = new OrderLineItems();
        orderLineItems1.setSkuCode(orderLineItems.getSkuCode());
        orderLineItems1.setPrice(orderLineItems.getPrice());
        orderLineItems1.setQuantity(orderLineItems.getQuantity());
        return orderLineItems1;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
