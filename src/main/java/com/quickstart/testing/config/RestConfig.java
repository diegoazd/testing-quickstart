package com.quickstart.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Configuration
@ComponentScan("com.quickstart.testing.mock")
public class RestConfig {

    @Bean
    public Client client() {
        return ClientBuilder.newClient();
    }
}
