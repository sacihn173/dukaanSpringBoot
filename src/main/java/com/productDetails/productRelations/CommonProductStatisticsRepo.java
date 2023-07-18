package com.productDetails.productRelations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommonProductStatisticsRepo extends JpaRepository<CommonProductStatistics, Integer> {

    @Query(
            value = "select * from common_product_statistics where product_id_A = :productIdA",
            nativeQuery = true
    )
    Optional<CommonProductStatistics> findByProductIdA(Integer productIdA);
}
