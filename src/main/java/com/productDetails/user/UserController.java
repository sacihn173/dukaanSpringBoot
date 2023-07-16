package com.productDetails.user;

import com.productDetails.dto.CreateUser;
import com.productDetails.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid CreateUser newUser) {
        return new ResponseEntity<UserDTO>(userService.registerUser(newUser), HttpStatus.CREATED);
    }

    // TODO : how to add check whether the user is updating his own data or not
    @GetMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserDTO user) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<UserDTO>(userService.updateUser(user), HttpStatus.OK);
    }

}
