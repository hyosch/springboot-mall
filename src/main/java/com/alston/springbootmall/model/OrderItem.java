package com.alston.springbootmall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "訂單明細對象", description = "訂單明細管理")
public class OrderItem {

    @ApiModelProperty(value = "明細編號")
    private int orderItemId;

    @ApiModelProperty(value = "訂單編號")
    private int orderId;

    @ApiModelProperty(value = "商品編號")
    private int productId;

    @ApiModelProperty(value = "數量")
    private int quantity;

    @ApiModelProperty(value = "小計")
    private int amount;

    @ApiModelProperty(value = "商品名稱")
    private String productName;

    @ApiModelProperty(value = "圖片")
    private String imageUrl;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
