package com.productDetails.product;

import com.productDetails.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductCategory(String productCategory);
}
