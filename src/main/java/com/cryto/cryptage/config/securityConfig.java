package com.cryto.cryptage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    //NOTE: Desactivation de la sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //HACK:  C'est un contournement temporaire; ne pas faire en production
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }

}
