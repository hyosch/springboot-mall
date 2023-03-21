package com.alston.springbootmall.dao;

import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
