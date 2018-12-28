package com.rabbitmqamqptutorials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DefaultConfiguration {

    @Profile("show_usage_message")
    @Bean
    public CommandLineRunner usage() {
        return args -> {
            System.out.println("This app uses Spring Profiles to control its behavior.\n");
                    System.out.println("Sample usage: java -jar rabbit-tutorials.jar " +
                            "--spring.profiles.active=hello-world,sender");
        };
    }

}
