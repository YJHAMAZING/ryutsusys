package com.wetech.ryutsuweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.wetech"})
@ComponentScan(basePackages = {"com.wetech.ryutsumodel","mapperxml"})
public class RyutsuwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RyutsuwebApplication.class, args);
    }

}
