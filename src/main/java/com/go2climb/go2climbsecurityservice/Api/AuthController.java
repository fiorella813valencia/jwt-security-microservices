package com.go2climb.go2climbsecurityservice.Api;

import com.go2climb.go2climbsecurityservice.Domain.Entity.UserCredential;
import com.go2climb.go2climbsecurityservice.Resource.CreateAuthentication;
import com.go2climb.go2climbsecurityservice.Service.AuthenticationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationServiceImp service;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user){
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody CreateAuthentication createAuthentication){
        Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(createAuthentication.getUsername(),createAuthentication.getPassword()));
        if(authenticate.isAuthenticated()){
            return service.generateToken(createAuthentication.getUsername());

        }else {
            throw new RuntimeException("invalid access");
        }
    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        service.validateToken(token);
        return "Token is valid";
    }
}
