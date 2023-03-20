package com.example.springapi_tests.service;

import com.example.springapi_tests.model.BoredActivity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoredApiService {
    private static final String BORED_API_URL = "https://www.boredapi.com/api/activity";

    private final RestTemplate restTemplate;

    public BoredApiService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BoredActivity getRandomActivity() {
        return restTemplate.getForObject(BORED_API_URL, BoredActivity.class);
    }
}

