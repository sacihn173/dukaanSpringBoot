package com.productDetails.trending;

import com.productDetails.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/trending")
public class TrendingController {

    @Autowired
    private TrendingService trendingService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getTrendingProducts(@RequestParam Integer pageNumber,
                                                             @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Product>>(
                trendingService.getTrendingProducts(pageNumber, pageSize), HttpStatus.OK);
    }


}
