package com.springSecurity.springSecurityImplementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/mybalance")
    public String getBalance(){
        return "my balance";
    }
}
