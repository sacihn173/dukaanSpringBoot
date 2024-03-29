package com.productDetails.user;

import com.productDetails.dto.CreateUser;
import com.productDetails.dto.UserDTO;
import com.productDetails.order.Order;
import com.productDetails.utility.NullAwareBeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserDTO registerUser(CreateUser newUser) {
        User user = new User(newUser.getPhoneNumber(), newUser.getPassword());
        userRepo.save(user);
        return new UserDTO(user.getUserId(), user.getPhoneNumber());
    }

    public UserDTO updateUser(UserDTO user) throws InvocationTargetException, IllegalAccessException {
        User dbUser = userRepo.findById(user.getUserId()).orElse(null);
        if(dbUser != null) {
            BeanUtilsBean notNull = new NullAwareBeanUtils();
            notNull.copyProperties(user, dbUser);
            return new UserDTO(dbUser.getUserId(), dbUser.getPhoneNumber());
        }
        return null;
    }

    public List<Integer> getUserProductHistory(Integer userId) {
        List<Integer> userHistory = new ArrayList<>();
        User user = userRepo.findById(userId).orElse(null);
        if(user != null) {
            for(Order order : user.getOrders()) {
                Integer orderProductId = order.getProduct().getProductId();
                userHistory.add(orderProductId);
            }
        }
        return userHistory;
    }

}
