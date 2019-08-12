package com.thehumblefool.movieinfodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(MovieInfoDemoApplication.class, args);
    }

}
