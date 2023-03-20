package com.example.springapi_tests.controller;

import com.example.springapi_tests.model.BoredActivity;
import com.example.springapi_tests.service.BoredApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoredApiController {
    private final BoredApiService boredApiService;

    public BoredApiController(BoredApiService boredApiService) {
        this.boredApiService = boredApiService;
    }

    @GetMapping("/activity")
    public BoredActivity getRandomActivity() {
        return boredApiService.getRandomActivity();
    }
}
