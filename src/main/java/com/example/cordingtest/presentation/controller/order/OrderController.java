package com.example.cordingtest.presentation.controller.order;

import com.example.cordingtest.domain.order.Order;
import com.example.cordingtest.presentation.controller.order.response.GetOrderListResponse;
import com.example.cordingtest.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<GetOrderListResponse> getOrderList() {
        var orderList = orderService.getOrderList();
        if (!CollectionUtils.isEmpty(orderList)) {
            return orderList.stream()
                    .map(GetOrderListResponse::fromOrder)
                    .toList();
        }
        return List.of();
    }
}
