package com.controledeinvestimento.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
public class HealthController {

    @GetMapping
    public Map<String, Object> health(){
        return Map.of("status","UP");
    }
}
