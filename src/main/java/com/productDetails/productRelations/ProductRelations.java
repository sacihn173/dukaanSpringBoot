package com.productDetails.productRelations;

import javax.persistence.*;
import java.util.List;

/**
 * Stores products that are related by tag to a product
 */
@Entity
@Table(name = "product_relations")
public class ProductRelations {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer productId;

    private List<Integer> relatedProducts;

    public ProductRelations(Integer productId, List<Integer> relatedProducts) {
        this.productId = productId;
        this.relatedProducts = relatedProducts;
    }

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

    public List<Integer> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(List<Integer> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }
}
