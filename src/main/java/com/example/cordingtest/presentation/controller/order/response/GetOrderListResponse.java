package com.example.cordingtest.presentation.controller.order.response;

import com.example.cordingtest.domain.order.Order;

import java.time.LocalDateTime;

public record GetOrderListResponse(
        Integer id,
        String productName,
        Integer quantity,
        LocalDateTime createdAt
) {
    public static GetOrderListResponse fromOrder(Order order) {
        return new GetOrderListResponse(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                order.getCreatedAt()
        );
    }
}
