package org.example.restro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RestroApplication {

    public static void main(String[] args) {
        log.info("Restro service started!");
        SpringApplication.run(RestroApplication.class, args);
    }

}

