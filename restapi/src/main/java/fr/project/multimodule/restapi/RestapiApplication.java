package fr.project.multimodule.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"fr.project.multimodule"})
@SpringBootApplication
public class RestapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }
}
