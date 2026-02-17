package com.example.cordingtest.domain.product;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(int id) {
    super("Product not found: " + id);
  }
}
