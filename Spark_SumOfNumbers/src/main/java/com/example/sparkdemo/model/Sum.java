package com.example.sparkdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sum {
    private int num;
    private String SumOfNumbers;
    private double sum;
}