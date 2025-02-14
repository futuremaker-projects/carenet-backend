package com.carenet.adminapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = {
        "com.carenet.admin", "com.carenet.adminapi",
        "com.carenet.common", "com.carenet.storage",
        "com.carenet.user"
})
public class CarenetAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarenetAdminApiApplication.class, args);
    }

}
