package com.productDetails.order;

import com.productDetails.dto.OrderDTO;
import com.productDetails.product.ProductRepo;
import com.productDetails.productRelations.CommonProductStatisticsService;
import com.productDetails.user.User;
import com.productDetails.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommonProductStatisticsService cpsService;

    /**
     * Update common_product_statistics (increase sales count of this product with all products in user history)
     */
    public OrderDTO createOrder(OrderDTO order) {
        Order newOrder = new Order();
        newOrder.setCancelled(false);
        newOrder.setProduct(productRepo.findById(order.getProductId()).orElseThrow());
        newOrder.setUser(userRepo.findById(order.getUserId()).orElseThrow());
        newOrder.setTimeCreated(new Date());
        orderRepository.save(newOrder);
        updateCommonProductStatistics(newOrder);
        order.setOrderId(newOrder.getOrderId());
        return order;
    }

    @Async
    public void updateCommonProductStatistics(Order order) {
        User user = userRepo.findById(order.getUser().getUserId()).orElse(null);
        if(user != null) {
             for(Order userOrder : user.getOrders()) {
                 if(userOrder != null) {
                     cpsService.increaseSalesStatistics
                             (order.getProduct().getProductId(), userOrder.getProduct().getProductId());
                 }
             }
        }
    }

}
