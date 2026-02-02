package com.example.cordingtest.service.order;

import com.example.cordingtest.domain.order.Order;
import com.example.cordingtest.repository.order.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  /**
   * 注文一覧を取得する
   *
   * @return 注文一覧
   */
  public List<Order> getOrderList() {
    return orderRepository.findAll();
  }
}
