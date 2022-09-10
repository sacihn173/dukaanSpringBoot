package com.productDetails.service;

import com.productDetails.model.AuthenticationRequest;
import com.productDetails.model.AuthenticationResponse;
import com.productDetails.model.Product;
import com.productDetails.model.User;
import com.productDetails.repository.ProductRepo;
import com.productDetails.repository.UserRepo;
import com.productDetails.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeServiceClass {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;


    public String createNewUser(User user){
        User newUser = new User(user);
        userRepo.save(newUser);
        return "Success!";
    }

    public String updateProductDetails(Product product){
        Product presentProduct = productRepo.findById(product.getProductId()).orElse(null);
        if(presentProduct != null){
            presentProduct.setProductPrice(product.getProductPrice());
            presentProduct.setProductCategory(product.getProductCategory());
            productRepo.save(presentProduct);
            return "Success";
        }
        else return "Not such product found!";
    }

    public String deleteProduct(int productId){
        Product toDelete = productRepo.findById(productId).orElse(null);
        if(toDelete != null){
            productRepo.delete(toDelete);
            return "Deleted!";
        }
        else return "No such product found!";
    }

    public Optional<Product> readByCategory(String category){
        return productRepo.findByProductCategory(category);
    }

    public Optional<Product> readByProductId(int productId){
        return productRepo.findById(productId);
    }

    public String createNewProduct(Product product){
        productRepo.save(new Product(product));
        return "Product created!";
    }
}
