package com.in28minutes.springboot.myfirstwebapp.security;

import java.util.function.Function;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
  // LDAP or Database
  // IN memory authentication

  // InMemoryUserDetailsManager
  // InMemoryUserDetailsManager(UserDetails... users)

  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

    UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder)
        .username("admin123")
        .password("admin123")
        .roles("USER").build();

    return new InMemoryUserDetailsManager(userDetails);
  }

  @Bean PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
