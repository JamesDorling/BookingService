package org.jam.bookingservice.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${authentication.protected-uri-ant-pattern}")
    private String unprotectedRequestMatchers;

    @Value("${authentication.protected-uri-ant-pattern}")
    private String protectedRequestMatchers;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable) //API will be stateless, so this can be disabled
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(unprotectedRequestMatchers).permitAll()
                .requestMatchers(protectedRequestMatchers).authenticated()
            );

        httpSecurity.addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }
}
