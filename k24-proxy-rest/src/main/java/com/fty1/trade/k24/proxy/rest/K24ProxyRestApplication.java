package com.fty1.trade.k24.proxy.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class K24ProxyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(K24ProxyRestApplication.class, args);
    }

}
