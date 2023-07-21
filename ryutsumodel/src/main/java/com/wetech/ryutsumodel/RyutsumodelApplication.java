package com.wetech.ryutsumodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wetech"})
public class RyutsumodelApplication {

    public static void main(String[] args) {
        SpringApplication.run(RyutsumodelApplication.class, args);
    }

}
