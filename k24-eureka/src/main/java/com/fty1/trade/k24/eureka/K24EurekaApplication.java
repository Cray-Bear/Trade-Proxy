package com.fty1.trade.k24.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class K24EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(K24EurekaApplication.class, args);
	}

}
