package com.productDetails.productRelations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TagProductsService {

    @Autowired
    private TagProductsRepo tagProductsRepo;

    /**
     * Adds the product to given tag, creates the tag if not present
     */
    public void addProductToTag(String tag, Integer productId) {
        TagProducts tagProducts = tagProductsRepo.findByTag(tag).orElse(null);
        if(tagProducts == null) {
            TagProducts newTagProducts = new TagProducts(tag, Collections.singletonList(productId));
            tagProductsRepo.save(newTagProducts);
        } else {
            tagProducts.getProductIds().add(productId);
            tagProductsRepo.save(tagProducts);
        }
    }

    /**
     * Get all products associated with a tag
     */
    public List<Integer> getProductsByTag(String tag) {
        List<Integer> products = new ArrayList<>();
        TagProducts tagProducts = tagProductsRepo.findByTag(tag).orElse(null);;
        if(tagProducts != null)
            products = tagProducts.getProductIds();
        return products;
    }

}
