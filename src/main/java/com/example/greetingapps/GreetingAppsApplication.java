package com.example.greetingapps;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.example.greetingapps.repository")
public class GreetingAppsApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(GreetingAppsApplication.class, args);
    }

}
