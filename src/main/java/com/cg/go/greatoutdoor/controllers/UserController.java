package com.cg.go.greatoutdoor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.go.greatoutdoor.dto.user.CreateUserRequest;
import com.cg.go.greatoutdoor.dto.user.UserSignUpResponse;
import com.cg.go.greatoutdoor.entity.Userdata;
import com.cg.go.greatoutdoor.service.AuthService;

@RestController
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signUp")
    public UserSignUpResponse addUser(@RequestBody CreateUserRequest requestData) {
    	return authService.userSignUp(new Userdata(
    			requestData.getUserName(),
                "ROLE_"+requestData.getUserType(),
                requestData.getUserPassword()
        ));
    }


    @GetMapping("/welcome")
    public String welcome(){
        return "<h1>Welcome</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "This is User";
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin";
    }


}