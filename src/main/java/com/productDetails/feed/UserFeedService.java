package com.productDetails.feed;

import com.productDetails.product.Product;
import com.productDetails.product.ProductRepo;
import com.productDetails.productRelations.CommonProductStatistics;
import com.productDetails.productRelations.CommonProductStatisticsService;
import com.productDetails.productRelations.ProductRelationsService;
import com.productDetails.user.UserRepo;
import com.productDetails.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class UserFeedService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRelationsService prService;

    @Autowired
    private CommonProductStatisticsService cpsService;

    @Autowired
    private ProductRepo productRepo;

    /**
     * Get User order history products
     * Get products related to them by tags
     * Sort the products based on common Sales and Impressions
     */
    public List<Product> getUserFeed(Integer userId, Integer pageNumber, Integer pageSize) {
        List<Integer> userHistoryProducts = userService.getUserProductHistory(userId);

        List<CommonProductStatistics> relatedProductsList = new ArrayList<>();
        for(Integer productId : userHistoryProducts) {
            relatedProductsList.addAll(cpsService.findByProductIdAOrderedBySalesAndImpressions(productId));
        }

        Collections.sort(relatedProductsList, new Comparator<CommonProductStatistics>() {
            @Override
            public int compare(CommonProductStatistics o1, CommonProductStatistics o2) {
                if(Objects.equals(o1.getCommonSales(), o2.getCommonSales()))
                    return o2.getCommonImpressions().compareTo(o1.getCommonImpressions());
                return o2.getCommonSales().compareTo(o1.getCommonSales());
            }
        });

        List<Product> recommendedProducts = new ArrayList<>();
        for(CommonProductStatistics p : relatedProductsList) {
            Product product = productRepo.findById(p.getProductIdB()).orElse(null);
            if(product != null)
                recommendedProducts.add(product);
        }
        return recommendedProducts;
    }

    // TODO:
    /* Generate feed not specific to user */
    public List<Product> getFeed(Integer pageNumber, Integer pageSize) {
        // get trending products with high sales and impressions
        return null;
    }

    // TODO:
    /* When having some tags for user from its current session */
    public List<Product> getFeedByTags(List<String> tags, Integer pageNumber, Integer pageSize) {
        return null;
    }

}
