package com.alston.springbootmall.service;

import com.alston.springbootmall.dto.ProductRequest;
import com.alston.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
