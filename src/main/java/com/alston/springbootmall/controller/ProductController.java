package com.alston.springbootmall.controller;

import com.alston.springbootmall.constant.ProductCategory;
import com.alston.springbootmall.dto.ProductQueryParams;
import com.alston.springbootmall.dto.ProductRequest;
import com.alston.springbootmall.exception.ApiRequestException;
import com.alston.springbootmall.model.Product;
import com.alston.springbootmall.service.ProductService;
import com.alston.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            // 排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "DESC") String sort,

            // 分頁 Paging
            @RequestParam(defaultValue = "5") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset
    ) {
        ProductQueryParams queryParams = new ProductQueryParams();
        queryParams.setCategory(category);
        queryParams.setSearch(search);
        queryParams.setOrderBy(orderBy);
        queryParams.setSort(sort);
        queryParams.setLimit(limit);
        queryParams.setOffset(offset);

        List<Product> plist = productService.getProducts(queryParams);

        Integer total = productService.countProducts(queryParams);

        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(plist);

        //return new ResponseEntity<Page<Product>>(page, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct (@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            throw new ApiRequestException("OOOOOOOps Not Found");
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping ("/products/{productId}")
    public ResponseEntity<Product> updateProduct (@PathVariable Integer productId,
                                                  @RequestBody @Valid ProductRequest productRequest) {
        Product product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);

    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct (@PathVariable Integer productId) {
        productService.deleteProduct(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
