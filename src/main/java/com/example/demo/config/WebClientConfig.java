package com.example.demo.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@AllArgsConstructor
public class WebClientConfig {
    private final WebClient.Builder webClientBuilder;

    @Bean("jsonPlaceholder")
    public WebClient jsonPlaceholderWebClient() {
        return webClientBuilder
                .build();
    }
}
