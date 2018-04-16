package com.Mp8TheMorseEncoder.encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
