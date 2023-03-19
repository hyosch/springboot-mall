package com.alston.springbootmall.dao;

import com.alston.springbootmall.dto.ProductRequest;
import com.alston.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
