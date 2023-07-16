package com.productDetails.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product createProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Async
    public void addSales(int productId) {
        Product product = productRepo.findById(productId).orElse(null);
        if(product != null) {
            product.setSales( (product.getSales() != null ? product.getSales() : 0) + 1);
            productRepo.save(product);
        }
    }

    // TODO : add mechanism for bulk update
    @Async
    public void addImpression(int productId) {
        productRepo.addImpression(productId, 1);
    }

}
