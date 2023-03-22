package com.alston.springbootmall.service;

import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.dto.OrderQueryParams;
import com.alston.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrders(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
