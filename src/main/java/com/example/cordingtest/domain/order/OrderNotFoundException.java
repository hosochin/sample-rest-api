package com.example.cordingtest.domain.order;

public class OrderNotFoundException extends RuntimeException {

  public OrderNotFoundException(int id) {
    super("Order not found: " + id);
  }
}
