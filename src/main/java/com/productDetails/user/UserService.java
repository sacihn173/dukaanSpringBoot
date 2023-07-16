package com.productDetails.user;

import com.productDetails.dto.CreateUser;
import com.productDetails.dto.UserDTO;
import com.productDetails.utility.NullAwareBeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

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
}
