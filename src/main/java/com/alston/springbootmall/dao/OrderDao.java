package com.alston.springbootmall.dao;

import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.model.Order;
import com.alston.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemById(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
