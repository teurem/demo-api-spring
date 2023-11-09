package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.entity.OrderEntity;
import com.example.onlinecarshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderEntity> getAllOrders()
    {
        List<OrderEntity> orders = orderService.getAllOrders();
        System.out.println("orders: " + orders);
        return orders;
    }

    @GetMapping("/{orderId}")
    public OrderEntity getOrderById(@PathVariable Long orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
        System.out.println("orderId: " +orderId+ "order: " + order);
        return order;
    }

    @PostMapping
    public String saveOrder(@RequestBody OrderEntity order)
    {
        orderService.saveOrder(order);
        return "order saved";
    }

    @PutMapping("/{orderId}")
    public String updateOrderStatus(@RequestBody OrderEntity order, Long orderId) {
        orderService.updateOrderStatus(order, orderId);
        return "order status update saccessfuly.";
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderid) {
        orderService.deleteOrder(orderid);
        return "order deleted saccessfuly.";
    }
}

