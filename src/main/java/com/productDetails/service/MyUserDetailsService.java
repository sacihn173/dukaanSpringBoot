package com.productDetails.service;

import com.productDetails.model.MyUserDetailsForSecurity;
import com.productDetails.model.User;
import com.productDetails.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = myUserRepo.findByPhoneNumber(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));

        return user.map(MyUserDetailsForSecurity::new).get();
    }
}
