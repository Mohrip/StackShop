// package com.user.user.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
 
// @Configuration
// public class SecurityConfig {
      
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/api/v1/customers/**").permitAll() // Allow access to customer endpoints
//                 .anyRequest().authenticated() // Secure other endpoints
//             )
//             .csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
//             .formLogin(form -> form.disable()) // Disable form-based login
//             .securityContext(securityContext -> securityContext.requireExplicitSave(false)) // Updated method for security context
//             .httpBasic(httpBasic -> httpBasic.realmName("StackShop")); // Configure basic authentication
//         return http.build();
//     }
// }

package com.user.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/customers/**").permitAll() // Allow access to customer endpoints
                .anyRequest().authenticated() // Secure other endpoints
            )
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing purposes
            .formLogin(form -> form.disable()) // Disable form-based login
            .httpBasic(httpBasic -> httpBasic.realmName("StackShop")); // Configure basic authentication
        return http.build();
    }
}
