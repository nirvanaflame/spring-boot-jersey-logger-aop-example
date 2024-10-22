package com.nf.thestartap.spring.aspect;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAspectApplication.class, args);
	}

	@Bean
	LoggerContext loggerContext() {
		return (LoggerContext) LoggerFactory.getILoggerFactory();
	}
}
