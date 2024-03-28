package com.springSecurity.springSecurityImplementation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDeveloper {
    @GetMapping("/hi")
    public String welcome(){
        return "Hi Dev";
    }
}
