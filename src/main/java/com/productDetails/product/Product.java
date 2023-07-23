package com.productDetails.product;

import com.productDetails.order.Order;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_details")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private Integer productPrice;

    private String description;

    private List<String> tags;

    private Integer sales;

    private Integer impressions;

    private Integer rank;

    private Integer salesInPeriod;

    private Integer impressionsInPeriod;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Product(){

    }

    public Product(Product product){
        this.productPrice = product.getProductPrice();
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Integer getSalesInPeriod() {
        return salesInPeriod;
    }

    public void setSalesInPeriod(Integer salesInPeriod) {
        this.salesInPeriod = salesInPeriod;
    }

    public Integer getImpressionsInPeriod() {
        return impressionsInPeriod;
    }

    public void setImpressionsInPeriod(Integer impressionsInPeriod) {
        this.impressionsInPeriod = impressionsInPeriod;
    }
}
