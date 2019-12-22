package com.fty1.trade.k24.proxy.audit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class K24ProxyAuditApplication {

    public static void main(String[] args) {
        SpringApplication.run(K24ProxyAuditApplication.class, args);
    }

}
