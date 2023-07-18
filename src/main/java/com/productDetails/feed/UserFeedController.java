package com.productDetails.feed;

import com.productDetails.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
public class UserFeedController {

    @Autowired
    private UserFeedService userFeedService;

    /* Generate feed specific for a user */
    @GetMapping("/user")
    public ResponseEntity<List<Product>> getUserFeed(@RequestParam Integer userId,
                                                     @RequestParam Integer pageNumber,
                                                     @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Product>>(userFeedService.getUserFeed(userId, pageNumber, pageSize), HttpStatus.OK);
    }

    /* Generate feed not specific to a user */
    @GetMapping("/anonymous")
    public ResponseEntity<List<Product>> getFeed(@RequestParam Integer pageNumber,
                                                 @RequestParam Integer pageSize) {
        return new ResponseEntity<List<Product>>(userFeedService.getFeed(pageNumber, pageSize), HttpStatus.OK);
    }

    /* Generate feed using tags */
    @PostMapping("/byTags")
    public ResponseEntity<List<Product>> getFeedByTags(@RequestParam Integer pageNumber,
                                                 @RequestParam Integer pageSize,
                                                 @RequestBody List<String> tags) {
        return new ResponseEntity<List<Product>>(userFeedService.getFeedByTags(tags, pageNumber, pageSize), HttpStatus.OK);
    }

}
