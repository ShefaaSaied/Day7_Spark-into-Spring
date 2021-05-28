package com.example.sparkdemo.controller;

import com.example.sparkdemo.service.SumOfNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumOfNumbersConroller{

    @Autowired
    private SumOfNumbersService SumOfNumbersService;

    @GetMapping("/SumOfNumbers")
    public double getSum() {
        return this.SumOfNumbersService.getSum();
    }
}
