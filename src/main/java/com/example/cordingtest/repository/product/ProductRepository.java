package com.example.cordingtest.repository.product;

import com.example.cordingtest.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Order, Integer> {}
