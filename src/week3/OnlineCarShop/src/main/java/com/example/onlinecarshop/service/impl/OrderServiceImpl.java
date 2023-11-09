package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.entity.OrderEntity;
import com.example.onlinecarshop.repository.OrderRepository;
import com.example.onlinecarshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(Long orderId) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(orderId);
        if (orderOpt.isPresent()) {
            return orderOpt.get();
        } else {
            throw new RuntimeException("order not found");
        }
    }

    @Override
    public void saveOrder(OrderEntity order) {
        OrderEntity orderDetail = orderRepository.save(order);
        System.out.println("order saved to db with userId" + orderDetail.getId());
    }

    @Override
    public void updateOrderStatus(OrderEntity order, Long orderId) {
        Optional<OrderEntity> orderDetailopt = orderRepository.findById(orderId);
        if (orderDetailopt.isPresent()) {
            OrderEntity orderDetail = orderDetailopt.get();
            if(order.getStatus() != null || order.getStatus().isEmpty())
                orderDetail.setStatus(order.getStatus());
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(orderId);
        if(orderOpt.isPresent()) {
            orderRepository.deleteById(orderId);
        }
        else
            throw new RuntimeException("order not found");
    }
}
