package com.springSecurity.springSecurityImplementation.controller;

import com.springSecurity.springSecurityImplementation.model.Customer;
import com.springSecurity.springSecurityImplementation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            if (customerRepository.save(customer).getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED
                ).body("Given user details are succesfully created");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CREATED
            ).body("GAn exception occured" + e.getMessage());

        }

        return null;
    }
}
