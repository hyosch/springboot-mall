package com.alston.springbootmall.dao;

import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.dto.OrderQueryParams;
import com.alston.springbootmall.model.Order;
import com.alston.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrders(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
