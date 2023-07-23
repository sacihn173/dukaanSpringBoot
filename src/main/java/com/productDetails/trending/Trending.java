package com.productDetails.trending;

import javax.persistence.*;
import java.util.Date;

/**
 * Contains the trending products in last 24 hours
 */

@Entity
@Table(name = "trending")
public class Trending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;

    private Date trendingTill;

    private Integer salesInPeriod;

    private Integer impressionsInPeriod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getTrendingTill() {
        return trendingTill;
    }

    public void setTrendingTill(Date trendingTill) {
        this.trendingTill = trendingTill;
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
