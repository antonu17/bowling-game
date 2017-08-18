package org.antonu.bowling.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.antonu")
public class RestApi {

    public static void main(String[] args) {
        SpringApplication.run(RestApi.class, args);
    }
}
