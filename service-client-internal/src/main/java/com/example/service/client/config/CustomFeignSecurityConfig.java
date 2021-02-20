package com.example.service.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
@EnableConfigurationProperties
public class CustomFeignSecurityConfig {

    @Bean
    @ConfigurationProperties(prefix = "my-resource.security.oauth2.client")
    public ClientCredentialsResourceDetails myClientCredentialsResourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean(name = "myOAuth2FeignRequestInterceptor")
    public OAuth2FeignRequestInterceptor myOAuth2FeignRequestInterceptor() {
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = myClientCredentialsResourceDetails();
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), clientCredentialsResourceDetails);
    }
}
