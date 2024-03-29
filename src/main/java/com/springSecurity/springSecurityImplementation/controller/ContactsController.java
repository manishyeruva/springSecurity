package com.springSecurity.springSecurityImplementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactsController {

    @GetMapping("/contacts")
    public String getcontacts(){
        return "contacts";
    }
}
