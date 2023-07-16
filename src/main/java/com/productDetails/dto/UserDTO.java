package com.productDetails.dto;

import javax.validation.constraints.Pattern;

public class UserDTO {

    private Integer userId;

    @Pattern(regexp = "^[0-9]{10}$", message = "invalid phone number")
    private String phoneNumber;

    public UserDTO (Integer userId, String phoneNumber) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
