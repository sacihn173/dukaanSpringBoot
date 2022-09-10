package com.productDetails.controller;

import com.productDetails.model.AuthenticationRequest;
import com.productDetails.model.AuthenticationResponse;
import com.productDetails.model.Product;
import com.productDetails.model.User;
import com.productDetails.service.HomeServiceClass;
import com.productDetails.service.MyUserDetailsService;
import com.productDetails.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HomeController {

    @Autowired
    private HomeServiceClass serviceClass;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("username or password not correct!", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwtToken = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestBody User userDetails){
        return serviceClass.createNewUser(userDetails);
    }

    @GetMapping("/read/{id}")
    public Optional<Product> readProductById(@PathVariable("id") int id){
        return serviceClass.readByProductId(id);
    }

    @GetMapping("/read/{category}")
    public Optional<Product> readByCategory(@PathVariable("category") String category){
        return serviceClass.readByCategory(category);
    }

    @PostMapping("/create")
    public String createNewProduct(@RequestBody Product productDetails){
        return serviceClass.createNewProduct(productDetails);
    }

    @PostMapping("/update")
    public String updateProductDetails(@RequestBody Product productDetails){
        return serviceClass.updateProductDetails(productDetails);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        return serviceClass.deleteProduct(id);
    }

}
