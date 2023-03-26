package com.alston.springbootmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "使用者對象", description = "使用者管理")
public class User {

    @ApiModelProperty(value = "編號")
    private Integer userId;

    @ApiModelProperty(value = "信箱")
    private String email;

    @JsonIgnore
    @ApiModelProperty(value = "密碼")
    private String password;

    @ApiModelProperty(value = "創建日期")
    private Date createdDate;

    @ApiModelProperty(value = "最後修改日期")
    private Date lastModifiedDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
