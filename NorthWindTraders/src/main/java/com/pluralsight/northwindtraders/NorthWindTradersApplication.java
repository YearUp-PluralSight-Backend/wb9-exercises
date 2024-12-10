package com.pluralsight.northwindtraders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NorthWindTradersApplication {

    private static final Logger log = LoggerFactory.getLogger(NorthWindTradersApplication.class);

    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(NorthWindTradersApplication.class, args);
        log.info(String.valueOf(ac));

        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
