package com.github.filipve1994.msconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class MsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConfigServerApplication.class, args);
	}

}
