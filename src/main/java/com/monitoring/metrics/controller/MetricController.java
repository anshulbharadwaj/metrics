package com.monitoring.metrics.controller;

import com.monitoring.metrics.service.MetricServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MetricController {

    @Autowired
    private MetricServiceImpl service;

    @PostMapping("/insert")
    public String pushData() {
        service.insertData();
        return "Data inserted successfully";
    }
}
