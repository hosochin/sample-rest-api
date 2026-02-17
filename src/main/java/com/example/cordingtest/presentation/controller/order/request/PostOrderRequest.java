package com.example.cordingtest.presentation.controller.order.request;

import com.example.cordingtest.domain.order.OrderUpdateCommand;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PostOrderRequest(
    @NotNull @Positive Integer productId, @NotNull @Positive Integer quantity) {

  /**
   * 注文情報に変換する
   *
   * @return 受注情報
   */
  public OrderUpdateCommand toOrderUpdateCommand() {
    return new OrderUpdateCommand(productId, quantity);
  }
}
