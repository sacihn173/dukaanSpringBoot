package com.productDetails.feed;

import com.productDetails.product.Product;

import java.util.List;

public class UserFeedService {

    /* Generate feed specific to userId */
    public List<Product> getUserFeed(Integer userId, Integer pageNumber, Integer pageSize) {
        // get list of orders of users to get products from them
        // now get related products and the common stats of the products
        // sort the products based on common stats
    }

    /* Generate feed not specific to user */
    public List<Product> getFeed(Integer pageNumber, Integer pageSize) {
        // get trending products with high sales and impressions
    }

    /* When having some tags for user from its current session */
    public List<Product> getFeedByTags(List<String> tags, Integer pageNumber, Integer pageSize) {

    }

}
