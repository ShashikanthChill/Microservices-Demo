package com.thehumblefool.eurekadiscoveryserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaDiscoveryServerDemoApplication.class, args);
    }

}
