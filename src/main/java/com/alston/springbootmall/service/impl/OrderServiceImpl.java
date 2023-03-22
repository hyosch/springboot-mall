package com.alston.springbootmall.service.impl;

import com.alston.springbootmall.dao.OrderDao;
import com.alston.springbootmall.dao.ProductDao;
import com.alston.springbootmall.dao.UserDao;
import com.alston.springbootmall.dto.BuyItem;
import com.alston.springbootmall.dto.CreateOrderRequest;
import com.alston.springbootmall.dto.OrderQueryParams;
import com.alston.springbootmall.model.Order;
import com.alston.springbootmall.model.OrderItem;
import com.alston.springbootmall.model.Product;
import com.alston.springbootmall.model.User;
import com.alston.springbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Integer countOrders(OrderQueryParams orderQueryParams) {
        return orderDao.countOrders(orderQueryParams);
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList = orderDao.getOrders(orderQueryParams);

        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // 檢查用戶是否存在
        User user = userDao.getUserById(userId);

        if (user == null) {
            log.warn("該用戶 {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

        //  清點庫存
            if (product.getStock() <= 0) {
                log.warn("商品 {} 無庫存", product.getProductName());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            if (product.getStock() < buyItem.getQuantity()) {
                log.warn("商品 {} 庫存不足, 尚餘 {}, 欲購買數量 {}",
                        product.getProductName(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
            productDao.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

        //  計算價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

        //  轉換 BuyItem 成 OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
