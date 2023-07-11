package com.productDetails.product;

import com.productDetails.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private int productPrice;
    private String productCategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Product(){

    }

    public Product(Product product){
        this.productPrice = product.getProductPrice();
        this.productCategory = product.getProductCategory();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
