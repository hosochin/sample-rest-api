package com.example.cordingtest.presentation.controller.product;

import com.example.cordingtest.domain.product.ProductNotFoundException;
import com.example.cordingtest.presentation.controller.order.request.PostOrderRequest;
import com.example.cordingtest.presentation.controller.order.request.PutOrderRequest;
import com.example.cordingtest.presentation.controller.order.response.GetOrderListResponse;
import com.example.cordingtest.service.order.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ProductController {

  private final OrderService orderService;

  @GetMapping("/products")
  public List<GetOrderListResponse> getOrderList() {
    var orderList = orderService.getOrderList();
    return orderList.stream().map(GetOrderListResponse::fromOrder).toList();
  }

  @PostMapping("/products")
  @ResponseStatus(HttpStatus.CREATED)
  public GetOrderListResponse saveOrder(@Valid @RequestBody PostOrderRequest postOrderRequest) {
    var result = orderService.saveOrder(postOrderRequest.toOrderUpdateCommand());
    return GetOrderListResponse.fromOrder(result);
  }

  @PutMapping("/products/{id}")
  public GetOrderListResponse updateOrder(
      @PathVariable Integer id, @Valid @RequestBody PutOrderRequest putOrderRequest) {
    var result = orderService.updateOrder(id, putOrderRequest.toOrderUpdateCommand());
    return GetOrderListResponse.fromOrder(result);
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ProblemDetail handleOrderNotFoundException(ProductNotFoundException ex) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
    problemDetail.setTitle("Not Found");
    problemDetail.setType(URI.create("about:blank"));
    return problemDetail;
  }
}
