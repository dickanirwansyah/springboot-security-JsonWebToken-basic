package com.dickanirwansyah.security.springbootjwtsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping(value = "/rest/hallo")
    public String getTestHallo(){
        return "Hallo Json Web Token !";
    }
}
