package com.springSecurity.springSecurityImplementation.config;

import com.springSecurity.springSecurityImplementation.model.Customer;
import com.springSecurity.springSecurityImplementation.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankSecurityConfiguration implements UserDetailsService {


    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      String userName, password=null;
      List<GrantedAuthority> authorties=null;
      List<Customer> customer =customerRepository.findByEmail(username);
      if(customer.size()==0) {
          throw new UsernameNotFoundException("user details nt found for the user name:" + username);
      }  else{
              userName=customer.get(0).getEmail();
              password=customer.get(0).getPwd();
              authorties=new ArrayList<>();
             authorties.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
          }
          return new User(username,password,authorties);
      }

}


