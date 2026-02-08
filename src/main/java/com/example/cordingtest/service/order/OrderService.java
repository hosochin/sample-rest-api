package com.example.cordingtest.service.order;

import com.example.cordingtest.domain.order.Order;
import com.example.cordingtest.domain.order.OrderUpdateCommand;
import com.example.cordingtest.domain.order.OrderNotFoundException;
import com.example.cordingtest.repository.order.OrderRepository;
import java.time.LocalDateTime;
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

  /**
   * 注文情報を新規登録する
   *
   * @param updateCommand 更新情報
   * @return 更新後の注文情報
   */
  public Order saveOrder(OrderUpdateCommand updateCommand) {
    return orderRepository.save(
        new Order(
            null, updateCommand.productName(), updateCommand.quantity(), LocalDateTime.now()));
  }

  /**
   * 注文情報を更新する
   *
   * @param id 更新対象のID
   * @param updateCommand 更新情報
   * @return 更新後の注文情報
   */
  public Order updateOrder(int id, OrderUpdateCommand updateCommand) {
    var existing =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new OrderNotFoundException(id));
    existing.update(updateCommand.productName(), updateCommand.quantity());
    return orderRepository.save(existing);
  }
}
