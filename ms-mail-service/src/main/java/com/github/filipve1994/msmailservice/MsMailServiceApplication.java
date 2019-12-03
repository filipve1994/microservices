package com.github.filipve1994.msmailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@EnableEurekaClient
@SpringBootApplication
public class MsMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMailServiceApplication.class, args);
	}

	@Bean
	public JavaMailSender mailSender(){
		return new JavaMailSenderImpl();
	}

}
