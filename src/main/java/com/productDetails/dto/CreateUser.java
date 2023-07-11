package com.productDetails.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CreateUser {

    @Pattern(regexp = "^[0-9]{10}$", message = "invalid phone number")
    private String phoneNumber;

    @NotBlank(message = "password cannot be blank")
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
