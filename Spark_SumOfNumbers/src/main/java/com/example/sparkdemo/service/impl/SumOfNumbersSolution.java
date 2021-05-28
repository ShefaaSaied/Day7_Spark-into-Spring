package com.example.sparkdemo.service.impl;
import com.example.sparkdemo.service.SumOfNumbersService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class SumOfNumbersSolution implements SumOfNumbersService {

    @Autowired
    private JavaSparkContext javaSparkContext;

    @Override
    public double getSum() {
        Logger.getLogger("org").setLevel(Level.OFF);

        JavaRDD<String> lines = javaSparkContext.textFile("in/prime_nums.text");

        JavaRDD<String> numbers = lines.flatMap(line -> Arrays.asList(line.split("\\s+")).iterator());

        JavaRDD<String> validNumbers = numbers.filter(number -> !number.isEmpty());
        JavaRDD<Integer> intNumbers = validNumbers.map(number -> Integer.valueOf(number));

        int SumOfNumbers = intNumbers.reduce((x, y) -> x + y);
        System.out.print("Sum Of Numbers= ");

        return SumOfNumbers;
    }
}