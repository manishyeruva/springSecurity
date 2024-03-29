package com.springSecurity.springSecurityImplementation.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests)
                -> requests.requestMatchers(
                        "/myAccount","/myBalance",
                "/cardDetails","/loanDetails").authenticated()
                .requestMatchers("/notices","/contacts").permitAll())
                 .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();

    }
        @Bean
        public InMemoryUserDetailsManager userDetailsService(){
            UserDetails admin= User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("12345")
                    .authorities("admin").build();
            UserDetails user= User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("12345")
                    .authorities("read").build();
            return new InMemoryUserDetailsManager(admin,user);
        }
}
