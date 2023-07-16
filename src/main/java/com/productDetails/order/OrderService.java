package com.productDetails.order;

import com.productDetails.dto.OrderDTO;
import com.productDetails.product.ProductRepo;
import com.productDetails.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    public OrderDTO createOrder(OrderDTO order) {
        Order newOrder = new Order();
        newOrder.setCancelled(false);
        newOrder.setProduct(productRepo.findById(order.getProductId()).orElseThrow());
        newOrder.setUser(userRepo.findById(order.getUserId()).orElseThrow());
        newOrder.setTimeCreated(new Date());
        orderRepository.save(newOrder);
        order.setOrderId(newOrder.getOrderId());
        return order;
    }

}
