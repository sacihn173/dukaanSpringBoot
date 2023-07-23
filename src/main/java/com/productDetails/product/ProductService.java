package com.productDetails.product;

import com.productDetails.productRelations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CommonAbstractCriteria;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private TagProductsService tagProductsService;

    @Autowired
    private ProductRelationsService productRelationsService;

    @Autowired
    private CommonProductStatisticsService commonProductStatisticsService;

    /**
     * Create product and
     */
    public Product createProduct(Product product) {
        productRepo.save(product);
        buildProductRelations(product);
        return product;
    }

    /**
     * add the product to corresponding tags in 'tag_products'
     * update the related products in 'product_relations'
     * update the common product stats in 'common_product_statistics'
     */
    @Async
    public void buildProductRelations(Product product) {
        Set<Integer> similarTagProducts = new HashSet<>();
        for(String tag : product.getTags()) {
            similarTagProducts.addAll(tagProductsService.getProductsByTag(tag));
            tagProductsService.addProductToTag(tag, product.getProductId());
        }

        for(Integer similarProductId : similarTagProducts) {
            productRelationsService.addProductInRelation(similarProductId, product.getProductId());
            productRelationsService.addProductInRelation(product.getProductId(), similarProductId);

            commonProductStatisticsService.increaseImpressionsStatistics(similarProductId, product.getProductId());
            commonProductStatisticsService.increaseImpressionsStatistics(product.getProductId(), similarProductId);
        }
    }

    @Async
    public void addSales(int productId) {
        // TODO : add salesInPeriod also
        Product product = productRepo.findById(productId).orElse(null);
        if(product != null) {
            product.setSales( (product.getSales() != null ? product.getSales() : 0) + 1);
            productRepo.save(product);
        }
    }

    // TODO: add mechanism for bulk update
    @Async
    public void addImpression(int productId) {
        productRepo.addImpression(productId, 1);
        // TODO : add impressionInPeriod also
    }

    /**
     * Get Products for Trending Page, order by impressions descending and then sales descending
     */
    public List<Product> getProductsWithHighestImpressionAndSales(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by("impressions").descending().and(Sort.by("sales").descending()));
        return productRepo.findAll(pageable).getContent();
    }

}
