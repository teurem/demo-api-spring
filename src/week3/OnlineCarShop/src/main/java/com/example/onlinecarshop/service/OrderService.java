package com.example.onlinecarshop.service;

import com.example.onlinecarshop.dto.OrderDTO;
import com.example.onlinecarshop.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long OrderId);
    void saveOrder(OrderEntity order);
    void updateOrderStatus(OrderEntity order, Long orderId);
    void deleteOrder(Long orderId);

}
