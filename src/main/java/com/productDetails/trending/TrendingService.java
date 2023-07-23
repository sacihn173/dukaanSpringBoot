package com.productDetails.trending;

import com.productDetails.product.Product;
import com.productDetails.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrendingService {

    @Autowired
    private ProductService productService;

    /**
     * Create a new table for trending and add new column to product with views in last 24 hours
     * every 24 hours a cron updates the trending table
     */
    /* Maybe customize based on tags for each customer */
    public List<Product> getTrendingProducts(Integer pageNumber, Integer pageSize) {
        return productService.getProductsWithHighestImpressionAndSales(pageNumber, pageSize);
    }

}
