package com.springSecurity.springSecurityImplementation.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.PasswordManagementDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf->csrf.disable()).authorizeHttpRequests((requests)
                -> requests.requestMatchers(
                        "/myAccount","/myBalance",
                "/cardDetails","/loanDetails").authenticated()
                .requestMatchers("/register","/notices","/contacts").permitAll())
                 .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();

    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//            System.out.println("hi");
//        return new JdbcUserDetailsManager((dataSource));
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//        @Bean
//        public InMemoryUserDetailsManager userDetailsService(){
//            UserDetails admin= User.withDefaultPasswordEncoder()
//                    .username("admin")
//                    .password("12345")
//                    .authorities("admin").build();
//            UserDetails user= User.withDefaultPasswordEncoder()
//                    .username("user")
//                    .password("12345")
//                    .authorities("read").build();
//            return new InMemoryUserDetailsManager(admin,user);
//        }
}
