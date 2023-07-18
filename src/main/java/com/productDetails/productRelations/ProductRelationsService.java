package com.productDetails.productRelations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ProductRelationsService {

    @Autowired
    private ProductRelationsRepo productRelationsRepo;

    public void addProductInRelation(Integer productIdA, Integer productIdB) {
        ProductRelations productRelations = productRelationsRepo.findByProductId(productIdA).orElse(null);
        if(productRelations != null) {
            productRelations.getRelatedProducts().add(productIdB);
            productRelationsRepo.save(productRelations);
        } else {
            ProductRelations newProductRelation = new ProductRelations(productIdA, Collections.singletonList(productIdB));
            productRelationsRepo.save(newProductRelation);
        }
    }

    public List<Integer> getRelatedProductIds(Integer productId) {
        List<Integer> relatedProducts = new ArrayList<>();
        ProductRelations productRelations = productRelationsRepo.findByProductId(productId).orElse(null);
        if(productRelations != null)
            relatedProducts = productRelations.getRelatedProducts();
        return relatedProducts;
    }

}
