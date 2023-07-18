package com.productDetails.productRelations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagProductsRepo extends JpaRepository<TagProducts, Integer> {

    @Query(
            value = "select * from tag_products where tag = :tag",
            nativeQuery = true
    )
    Optional<TagProducts> findByTag(String tag);
}
