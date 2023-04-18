package com.softuni.petselect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PetSelectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetSelectApplication.class, args);
    }

}
