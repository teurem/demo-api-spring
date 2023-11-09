package com.example.onlinecarshop.controller;

import com.example.onlinecarshop.dto.OrderDTO;
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
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = orderService.getAllOrders();
        System.out.println("orders: " + orders);
        return orders;
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable Long orderId) {
        OrderDTO order = orderService.getOrderById(orderId);
        System.out.println("orderId: " +orderId+ "order: " + order);
        return order;
    }

    @PostMapping
    public String saveOrder(@RequestBody OrderEntity order)
    {
        orderService.saveOrder(order);
        return "order saved successfuly";
    }

    @PutMapping("/{orderId}")
    public String updateOrderStatus(@RequestBody OrderEntity order, @PathVariable Long orderId) {
        orderService.updateOrderStatus(order, orderId);
        return "order status update successfuly.";
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return "order deleted successfuly.";
    }
}

