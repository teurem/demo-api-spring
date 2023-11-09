package com.example.onlinecarshop.service.impl;

import com.example.onlinecarshop.dto.OrderDTO;
import com.example.onlinecarshop.entity.OrderEntity;
import com.example.onlinecarshop.repository.OrderRepository;
import com.example.onlinecarshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private OrderDTO convertingEntityToDto(OrderEntity order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDates(order.getDates());
        orderDTO.setSum(order.getSum());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertingEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .map(this::convertingEntityToDto)
                .orElseThrow(() -> new RuntimeException("order not found"));
    }

//    @Override
//    public OrderEntity getOrderById(Long orderId) {
//        Optional<OrderEntity> orderOpt = orderRepository.findById(orderId);
//        if (orderOpt.isPresent()) {
//            return orderOpt.get();
//        } else {
//            throw new RuntimeException("order not found");
//        }
//    }

    @Override
    public void saveOrder(OrderEntity order) {
        OrderEntity orderDetail = orderRepository.save(order);
        System.out.println("order saved to db with orderId" + orderDetail.getId());
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
