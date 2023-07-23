package com.productDetails.trending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendingRepo extends JpaRepository<Trending, Integer> {
}
