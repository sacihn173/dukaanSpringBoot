package com.productDetails.productRelations;

import javax.persistence.*;

/**
 * Defines relation between products in terms of common statistics like 'Sales', 'Impressions'
 */

@Entity
@Table(name = "common_product_statistics")
public class CommonProductStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productIdA;

    private Integer productIdB;

    private Integer commonImpressions;

    private Integer commonSales;

    public CommonProductStatistics(Integer productIdA, Integer productIdB, int commonImpressions, int commonSales) {
        this.productIdA = productIdA;
        this.productIdB = productIdB;
        this.commonImpressions = commonImpressions;
        this.commonSales = commonSales;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductIdA() {
        return productIdA;
    }

    public void setProductIdA(Integer productIdA) {
        this.productIdA = productIdA;
    }

    public Integer getProductIdB() {
        return productIdB;
    }

    public void setProductIdB(Integer productIdB) {
        this.productIdB = productIdB;
    }

    public Integer getCommonImpressions() {
        return commonImpressions;
    }

    public void setCommonImpressions(Integer commonImpressions) {
        this.commonImpressions = commonImpressions;
    }

    public Integer getCommonSales() {
        return commonSales;
    }

    public void setCommonSales(Integer commonSales) {
        this.commonSales = commonSales;
    }
}
