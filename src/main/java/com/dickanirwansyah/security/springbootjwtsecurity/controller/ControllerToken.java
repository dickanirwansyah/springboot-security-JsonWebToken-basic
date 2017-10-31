package com.dickanirwansyah.security.springbootjwtsecurity.controller;

import com.dickanirwansyah.security.springbootjwtsecurity.model.User;
import com.dickanirwansyah.security.springbootjwtsecurity.security.JwtGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerToken {

    private JwtGenerator jwtGenerator;

    public ControllerToken(JwtGenerator jwtGenerator){
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(value = "/token")
    public String getRequestToken(@RequestBody final User user){
        return jwtGenerator.generate(user);
    }
}
