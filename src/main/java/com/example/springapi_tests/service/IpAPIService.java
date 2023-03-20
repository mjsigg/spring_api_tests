package com.example.springapi_tests.service;

import com.example.springapi_tests.model.IpAPI;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class IpAPIService {
    private final RestTemplate restTemplate;

    private String IP_API_URL = "http://ip-api.com/json/";

    public IpAPIService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private IpAPI getApiResponse(RestTemplate restTemplate) {
        return restTemplate.getForObject(IP_API_URL, IpAPI.class);
    }
}
