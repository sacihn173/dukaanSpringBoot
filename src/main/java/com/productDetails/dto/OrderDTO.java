package com.productDetails.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderDTO {

    private Integer orderId;

    private Date timeCreated;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer productId;

    public OrderDTO(Integer orderId, Date timeCreated, Integer userId, Integer productId) {
        this.orderId = orderId;
        this.timeCreated = timeCreated;
        this.userId = userId;
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
