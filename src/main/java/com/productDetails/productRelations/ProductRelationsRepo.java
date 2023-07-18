package com.productDetails.productRelations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRelationsRepo extends JpaRepository<ProductRelations, Integer> {

    @Query(
            value = "select * from product_relations where product_id = :productIdA",
            nativeQuery = true
    )
    Optional<ProductRelations> findByProductId(Integer productIdA);
}
