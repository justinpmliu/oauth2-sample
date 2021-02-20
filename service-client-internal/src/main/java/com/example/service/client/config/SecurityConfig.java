package com.example.service.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
@Order(value = 0)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()  
            .and()
            .csrf()
            .disable();
    }

    @Bean
    @Autowired
    public OAuth2RestOperations restTemplate(ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails);
    }

    @Bean
    @Autowired
    public OAuth2FeignRequestInterceptor oAuth2FeignRequestInterceptor(ClientCredentialsResourceDetails clientCredentialsResourceDetails) {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }
}

