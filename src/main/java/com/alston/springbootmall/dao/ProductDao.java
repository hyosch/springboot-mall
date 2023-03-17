package com.alston.springbootmall.dao;

import com.alston.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
