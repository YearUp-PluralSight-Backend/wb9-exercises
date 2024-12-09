package com.pluralsight.northwindtraders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NorthWindTradersApplication {

    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(NorthWindTradersApplication.class, args);
    }

}
