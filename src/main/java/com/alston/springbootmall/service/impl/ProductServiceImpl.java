package com.alston.springbootmall.service.impl;

import com.alston.springbootmall.dao.ProductDao;
import com.alston.springbootmall.dto.ProductQueryParams;
import com.alston.springbootmall.dto.ProductRequest;
import com.alston.springbootmall.model.Product;
import com.alston.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProducts(ProductQueryParams queryParams) {
        return productDao.countProducts(queryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams queryParams) {
        return productDao.getProducts(queryParams);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }

}
