package com.lqs.demo;
import love.forte.simboot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSimbot
@EnableScheduling
@SpringBootApplication
public class SimBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimBotApplication.class,args);
    }
}
