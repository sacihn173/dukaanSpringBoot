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

    /* Maybe customize based on tags for each customer */
    public List<Product> getTrendingProducts(Integer pageNumber, Integer pageSize) {
        return productService.getProductsWithHighestImpressionAndSales(pageNumber, pageSize);
    }

}
