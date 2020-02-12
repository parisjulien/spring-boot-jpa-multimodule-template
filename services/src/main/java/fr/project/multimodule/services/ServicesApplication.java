package fr.project.multimodule.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"fr.project.multimodule"})
@SpringBootApplication
public class ServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicesApplication.class, args);
    }
}
