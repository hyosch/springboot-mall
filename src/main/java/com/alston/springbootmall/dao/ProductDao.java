package com.alston.springbootmall.dao;

import com.alston.springbootmall.constant.ProductCategory;
import com.alston.springbootmall.dto.ProductQueryParams;
import com.alston.springbootmall.dto.ProductRequest;
import com.alston.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams queryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

}
