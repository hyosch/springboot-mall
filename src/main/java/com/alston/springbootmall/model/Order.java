package com.alston.springbootmall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "訂單對象", description = "訂單管理")
public class Order {

    @ApiModelProperty(value = "訂單編號")
    private int orderId;

    @ApiModelProperty(value = "使用者編號")
    private int userId;

    @ApiModelProperty(value = "總金額")
    private int totalAmount;

    @ApiModelProperty(value = "創建日期")
    private Date createdDate;

    @ApiModelProperty(value = "最後修改日期")
    private Date lastModifiedDate;

    private List<OrderItem> orderItemList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
