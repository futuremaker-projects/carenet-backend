package com.carenet.examapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = {
        "com.carenet.common", "com.carenet.exam",
        "com.carenet.storage", "com.carenet.examapi"
})
public class CarenetExamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarenetExamApiApplication.class, args);
    }

}
