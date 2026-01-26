package com.example.cordingtest.service.order;

import com.example.cordingtest.domain.order.Order;
import com.example.cordingtest.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

}
