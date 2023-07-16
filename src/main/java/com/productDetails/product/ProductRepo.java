package com.productDetails.product;

import com.productDetails.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductCategory(String productCategory);

    // TODO : check the query, add mechanism for bulk update into function
    @Query(
            value = "update product_details set impressions = :impressions + (select impressions from " +
                    "product_details where product_id = :productId",
            nativeQuery = true
    )
    Product addImpression(int productId, int impressions);

}
