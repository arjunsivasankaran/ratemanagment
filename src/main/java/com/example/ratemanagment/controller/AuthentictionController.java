package com.example.ratemanagment.controller;

import com.example.ratemanagment.exception.InavlidCredentialException;
import com.example.ratemanagment.model.TokenResponse;
import com.example.ratemanagment.model.User;
import com.example.ratemanagment.util.JWTUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthentictionController {

    @Autowired
    JWTUtil jwtutil;

    @PostMapping(value = "/authenticate", consumes = "application/json")
    public TokenResponse login(@RequestBody User creds) throws InavlidCredentialException {
        if(!creds.getUser().equals("arjun") || !creds.getPassword().equals("password")){
            throw new InavlidCredentialException("Bad Request");
        }
        String token = jwtutil.getJWTToken(creds.getUser());
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return tokenResponse;

    }

}

