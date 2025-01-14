package org.fury.advent.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AdventOfCodeProcessor {
    public static void main(String[] args) {
        SpringApplication.run(AdventOfCodeProcessor.class, args);
    }
}