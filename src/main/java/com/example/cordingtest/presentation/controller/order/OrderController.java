package com.example.cordingtest.presentation.controller.order;

import com.example.cordingtest.presentation.controller.order.response.GetOrderListResponse;
import com.example.cordingtest.service.order.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/orders")
  public List<GetOrderListResponse> getOrderList() {
    var orderList = orderService.getOrderList();
    return orderList.stream().map(GetOrderListResponse::fromOrder).toList();
  }
}
