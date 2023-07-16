package com.productDetails.user;

import com.productDetails.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String phoneNumber;

    private String password;

    private String roles;

    private boolean active;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    public User(User user){
        this.phoneNumber = user.getPhoneNumber();
        this.password = user.getPassword();
        this.roles = "ROLE_" + user.getRoles();
        this.active = user.isActive();
    }

    public User (String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.active = true;
        // assign customer role
    }

    public User(){
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
