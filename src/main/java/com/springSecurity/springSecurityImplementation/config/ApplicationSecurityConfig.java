package com.springSecurity.springSecurityImplementation.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests)
                -> requests.requestMatchers(
                        "/account/myAccount","/balance/myBalance",
                "/cardDetails","/loans/loanDetails").authenticated()
                .requestMatchers("/notices","/contacts").permitAll())
                 .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();


    }

    //deny all
        //            http.authorizeHttpRequests((requests)
        //            -> requests.anyRequest().denyAll())
        //            .formLogin(withDefaults())
        //            .httpBasic(withDefaults());
        //        return http.build();


    //permit all
    //            http.authorizeHttpRequests((requests)
    //            -> requests.anyRequest().permitAll())
    //            .formLogin(withDefaults())
    //            .httpBasic(withDefaults());
    //        return http.build();
}
