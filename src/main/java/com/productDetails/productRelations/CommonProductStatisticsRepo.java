package com.productDetails.productRelations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommonProductStatisticsRepo extends JpaRepository<CommonProductStatistics, Integer> {

    @Query(
            value = "select * from common_product_statistics where product_id_a = :productIdA",
            nativeQuery = true
    )
    List<CommonProductStatistics> findByProductIdA(Integer productIdA);

    @Query(
            value = "select * from common_product_statistics where product_id_a = :productIdA and product_id_b = :productIdB",
            nativeQuery = true
    )
    CommonProductStatistics findByProductIdAAndProductIdB(Integer productIdA, Integer productIdB);

    @Query(
            value = "select * from common_product_statistics where product_id_a = :productIdA order by common_sales desc," +
                    "common_impressions desc",
            nativeQuery = true
    )
    List<CommonProductStatistics> findByProductIdAOrderedBySalesAndImpressions(Integer productAId);
}
