package com.rabbitmqamqptutorials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Profile("!show_usage_message")
@Component
@EnableScheduling
public class RabbitCommandLineRunner implements CommandLineRunner {

    private final ConfigurableApplicationContext context;

    private final int duration;

    RabbitCommandLineRunner(ConfigurableApplicationContext context, @Value("${tutorial.client.duration:0}") final  int duration) {
        this.context=context;
        this.duration=duration;
    }

    @Override
    public void run(String... arg0) throws Exception {
        System.out.println("Ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        context.close();
    }
}
