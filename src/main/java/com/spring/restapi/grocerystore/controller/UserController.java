package com.spring.restapi.grocerystore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.restapi.grocerystore.dao.UserRepository;
import com.spring.restapi.grocerystore.dto.ResponseDto;
import com.spring.restapi.grocerystore.dto.SignInDto;
import com.spring.restapi.grocerystore.dto.SignInResponseDto;
import com.spring.restapi.grocerystore.dto.SignupDto;
import com.spring.restapi.grocerystore.dto.UserUpdateDto;
import com.spring.restapi.grocerystore.exceptions.AuthenticationFailException;
import com.spring.restapi.grocerystore.exceptions.CustomException;
import com.spring.restapi.grocerystore.model.User;
import com.spring.restapi.grocerystore.service.AuthenticationService;
import com.spring.restapi.grocerystore.service.UserService;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }
    
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
    	 this.userService.updateUser(user);
    	 return "Details Updated Successfully..!";
    }
}
