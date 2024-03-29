package com.springSecurity.springSecurityImplementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccount(){
        return "my account";
    }


}
