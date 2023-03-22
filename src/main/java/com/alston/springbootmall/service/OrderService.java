package com.alston.springbootmall.service;

import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
