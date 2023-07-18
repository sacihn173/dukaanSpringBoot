package com.productDetails.productRelations;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class TagProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tagId;

    private String tag;

    private List<Integer> productIds;

    public TagProducts(String tag, List<Integer> productIds) {
        this.tag = tag;
        this.productIds = productIds;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
