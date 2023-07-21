package com.wetech.ryutsuweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wetech"})
public class RyutsuwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RyutsuwebApplication.class, args);
    }

}
